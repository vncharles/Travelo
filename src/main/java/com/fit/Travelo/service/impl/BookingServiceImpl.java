package com.fit.Travelo.service.impl;

import com.fit.Travelo.entity.*;
import com.fit.Travelo.exception.BadRequestException;
import com.fit.Travelo.exception.ForbiddenException;
import com.fit.Travelo.exception.NotFoundException;
import com.fit.Travelo.mapper.BookingMapper;
import com.fit.Travelo.model.BookingDTO;
import com.fit.Travelo.model.request.BookingRequest;
import com.fit.Travelo.repository.BookingRepository;
import com.fit.Travelo.repository.CustomerRepository;
import com.fit.Travelo.repository.StaffRepository;
import com.fit.Travelo.repository.TourRepository;
import com.fit.Travelo.service.BookingService;
import com.fit.Travelo.utils.Authen;
import com.fit.Travelo.utils.EmailTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final StaffRepository staffRepository;
    private final TourRepository tourRepository;
    private final EmailSenderService senderService;
    @Override
    public List<BookingDTO> getList() {

        List<Booking> list = bookingRepository.findAll();
        return list.stream().map((booking) ->{
            return BookingMapper.bookingToBookingDTO(booking);

        }).toList();

    }

    @Override
    public Booking getDetail(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Booking id is not found");
        });
        return booking;
    }

    @Override
    public void addByCustomer(BookingRequest request) {
        Customer customer = null;
        if(request.getCustomerId() != null) {
            try {
                customer = customerRepository.findById(request.getCustomerId()).get();
            }catch (Exception e){
                customer = null;
            }
        }
        if (customer == null){
            if (request.getEmail() == null || request.getName() == null){
                throw new BadRequestException(400, "email and name need be required");
            }

            customer = customerRepository.findByEmail(request.getEmail());
            if (customer == null) {
                customer = new Customer();
                customer.setEmail(request.getEmail() != null ? request.getEmail() : null);
                customer.setName(request.getName() != null ? request.getName() : null);
                customer.setAddress(request.getAddress() != null ? request.getAddress() : null);
                customer.setPhone(request.getPhone() != null ? request.getPhone() : null);
                customerRepository.save(customer);
                customer = customerRepository.findByEmail(request.getEmail());
            }else {
                customer.setName(request.getName() != null ? request.getName() : null);
                customer.setAddress(request.getAddress() != null ? request.getAddress() : null);
                customer.setPhone(request.getPhone() != null ? request.getPhone() : null);

                customerRepository.save(customer);
            }
        }
        Tour tour = tourRepository.findById(request.getTourId()).orElseThrow(()->{
            throw new NotFoundException(404, "Tour Id is not found");
        });

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setTour(tour);
        booking.setCreatedAt(LocalDate.now());
        booking.setNumberPerson(request.getNumberPerson());
        booking.setStatus(EStatusBooking.NEW);
        booking.setTotalPrice(booking.getTotalPrice());

        Booking newBooking = bookingRepository.save(booking);

        if(newBooking!=null) senderService.sendEmail(booking.getCustomer().getEmail(), "Thông tin đặt tour Travelo", EmailTemplate.sendMailBooking(newBooking));
    }

    @Override
    public void addByStaff(BookingRequest request) {
        if (request.getNumberPerson() == null || request.getNumberPerson() <= 0)
            throw new BadRequestException(400, "Number person must be required and greater than 0");

        Customer customer = null;
        if(request.getCustomerId() != null) {
            try {
                customer = customerRepository.findById(request.getCustomerId()).get();
            }catch (Exception e){
                customer = null;
            }
        }
        if (customer == null){

            if (request.getEmail() == null || request.getName() == null){
                throw new BadRequestException(400, "email and name must be required");
            }

            customer = customerRepository.findByEmail(request.getEmail());
            if (customer == null) {
                customer = new Customer();
                customer.setEmail(request.getEmail() != null ? request.getEmail() : null);
                customer.setName(request.getName() != null ? request.getName() : null);
                customer.setAddress(request.getAddress() != null ? request.getAddress() : null);
                customer.setPhone(request.getPhone() != null ? request.getPhone() : null);

                customerRepository.save(customer);
                customer = customerRepository.findByEmail(request.getEmail());
            } else {
                customer.setName(request.getName() != null ? request.getName() : null);
                customer.setAddress(request.getAddress() != null ? request.getAddress() : null);
                customer.setPhone(request.getPhone() != null ? request.getPhone() : null);

                customerRepository.save(customer);
            }
        }
        Tour tour = tourRepository.findById(request.getTourId()).orElseThrow(()->{
            throw new NotFoundException(404, "Tour Id is not found");
        });

//        String email = Authen.getEmail();
//        Staff staff = staffRepository.findStaffByEmail(email);

        Staff staff = null;
        if (request.getStaffId() != null){
             staff = staffRepository.findById(request.getStaffId()).orElseThrow(()->{
                throw new NotFoundException(404, "Staff Id is not found");
            });
        }

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setStaff(staff);
        booking.setTour(tour);
        booking.setNumberPerson(request.getNumberPerson());
        booking.setStatus(EStatusBooking.NEW);
        booking.setTotalPrice(booking.getTotalPrice());
        bookingRepository.save(booking);
    }
    @Override
    public void update(Long id, BookingRequest request) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Booking id is not found");
        });

        if (booking.getStatus() != EStatusBooking.NEW && booking.getStatus() != EStatusBooking.UNPAID)
            throw new ForbiddenException(404, booking.getStatus().name() + " Booking, can not update anything");

        if (request.getNumberPerson() != null){
            booking.setNumberPerson(request.getNumberPerson());
        }

        if (request.getStatus() != null){
            booking.setStatus(request.getStatus());
        }
        bookingRepository.save(booking);
    }

    @Override
    public void delete(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Booking id is not found");
        });
        booking.setStatus(EStatusBooking.CANCEL);
        bookingRepository.save(booking);
    }

    @Override
    public List<BookingDTO> getListByEmail(String email) {
        List<Booking> list = bookingRepository.findByCustomer_EmailOrderByCreatedAtDesc(email);
        return list.stream().map((booking) ->{
            return BookingMapper.bookingToBookingDTO(booking);

        }).toList();
    }
}
