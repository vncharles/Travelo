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
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        List<Booking> list = bookingRepository.findAllOrderByCreatedAtDesc();
        return list.stream().map((booking) ->{
            return BookingMapper.bookingToBookingDTO(booking);

        }).toList();

    }

    @Override
    public BookingDTO getDetail(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Booking id is not found");
        });
        return BookingMapper.bookingToBookingDTO(booking);
    }

    @Override
    public void addByCustomer(BookingRequest request) {

        if (request.getTourId() == null){
            throw new BadRequestException(400, "TourId must be required");
        }

        Tour tour = tourRepository.findById(request.getTourId()).orElseThrow(()->{
            throw new NotFoundException(404, "Tour Id is not found");
        });

        if (!tourRepository.existsByIdAndStartDateAfter(request.getTourId(), LocalDateTime.now())){
            throw new BadRequestException(400, "Tour is not current on sale");
        }



        if (request.getNumberPerson() == null || request.getNumberPerson() <= 0)
            throw new BadRequestException(400, "Number person must be required and greater than 0");


        if (request.getEmail() == null || request.getName() == null){
            throw new BadRequestException(400, "email and name need be required");
        }

        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(request.getEmail());
        if (!matcher.matches()) {
            throw new BadRequestException(400, "Email sai định dạng!");
        }

        pattern = Pattern.compile("^(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})$");
        matcher = pattern.matcher(request.getPhone());
        if(!matcher.matches()) {
            throw new BadRequestException(400, "Số điện thoại sai định dạng");
        }

        Customer customer = customerRepository.findByEmail(request.getEmail());
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


        if (tour.getStock() < request.getNumberPerson())
            throw new BadRequestException(400, "number person can not greater than stock");

        tour.decreaseStock(request.getNumberPerson());

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

        if (request.getEmail() == null || request.getName() == null){
            throw new BadRequestException(400, "email and name must be required");
        }

        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(request.getEmail());
        if (!matcher.matches()) {
            throw new BadRequestException(400, "Email sai định dạng!");
        }

        pattern = Pattern.compile("^(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})$");
        matcher = pattern.matcher(request.getPhone());
        if(!matcher.matches()) {
            throw new BadRequestException(400, "Số điện thoại sai định dạng");
        }

        Customer customer = customerRepository.findByEmail(request.getEmail());
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

        Tour tour = tourRepository.findById(request.getTourId()).orElseThrow(()->{
            throw new NotFoundException(404, "Tour Id is not found");
        });

        Staff staff = staffRepository.findStaffByEmail(Authen.getEmail());

        if (tour.getStock() < request.getNumberPerson())
            throw new BadRequestException(400, "number person can not greater than stock");

        tour.setStock(tour.getStock()-request.getNumberPerson());
        System.out.println("Stock: " + tour.getStock());
        tourRepository.saveAndFlush(tour);

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setStaff(staff);
        booking.setTour(tour);
        booking.setCreatedAt(LocalDate.now());
        booking.setNumberPerson(request.getNumberPerson());
        booking.setStatus(EStatusBooking.UNPAID);
        booking.setTotalPrice(booking.getTotalPrice());

        Booking newBooking = bookingRepository.save(booking);

        if(newBooking!=null) senderService.sendEmail(booking.getCustomer().getEmail(), "Thông tin đặt tour Travelo", EmailTemplate.sendMailBooking(newBooking));
    }
    @Override
    public void update(Long id, BookingRequest request) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Booking không tồn tại");
        });

        if (booking.getStatus() != EStatusBooking.NEW && booking.getStatus() != EStatusBooking.UNPAID)
            throw new BadRequestException(400, "Vé không thể hủy");

        if (request.getStatus() != null){
            Staff staff = staffRepository.findStaffByEmail(Authen.getEmail());
            booking.setStaff(staff);
            booking.setStatus(EStatusBooking.valueOf(request.getStatus()));
        }

        Customer customer = booking.getCustomer();
        if(request.getPhone()!=null) {
            Pattern pattern = Pattern.compile("^(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})$");
            Matcher matcher = pattern.matcher(request.getPhone());
            if(!matcher.matches()) {
                throw new BadRequestException(400, "Số điện thoại sai định dạng");
            }

            customer.setPhone(request.getPhone());
        }
        if(request.getName()!=null) customer.setName(request.getName());
        if(request.getAddress()!=null) customer.setAddress(request.getAddress());

        customerRepository.save(customer);
        bookingRepository.save(booking);
    }

    @Override
    public void delete(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Booking không tồn tại");
        });

        if (booking.getStatus() != EStatusBooking.NEW && booking.getStatus() != EStatusBooking.UNPAID)
            throw new BadRequestException(400, "Vé không thể hủy");

        Tour tour = booking.getTour();
        tour.increaseStock(booking.getNumberPerson());
        tourRepository.save(tour);

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
