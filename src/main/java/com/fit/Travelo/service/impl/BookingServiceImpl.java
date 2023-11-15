package com.fit.Travelo.service.impl;

import com.fit.Travelo.entity.*;
import com.fit.Travelo.exception.NotFoundException;
import com.fit.Travelo.model.request.BookingRequest;
import com.fit.Travelo.repository.BookingRepository;
import com.fit.Travelo.repository.CustomerRepository;
import com.fit.Travelo.repository.StaffRepository;
import com.fit.Travelo.repository.TourRepository;
import com.fit.Travelo.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final StaffRepository staffRepository;
    private final TourRepository tourRepository;
    @Override
    public List<Booking> getList() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getDetail(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Booking id is not found");
        });
        return booking;
    }

    @Override
    public void add(BookingRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow(()->{
            throw new NotFoundException(404, "Customer Id is not found");
        });
        Staff staff = staffRepository.findById(request.getStaffId()).orElseThrow(()->{
            throw new NotFoundException(404, "Staff Id is not found");
        });
        Tour tour = tourRepository.findById(request.getTourId()).orElseThrow(()->{
            throw new NotFoundException(404, "Tour Id is not found");
        });

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setStaff(staff);
        booking.setTour(tour);
        booking.setNumberPerson(request.getNumberPerson());
        booking.setStatus(request.getStatus());
        booking.setTotalPrice(request.getTotalPrice());

        bookingRepository.save(booking);

    }

    @Override
    public void update(Long id, BookingRequest request) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Booking id is not found");
        });

        if (request.getCustomerId() != null){
            Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow(()->{
                throw new NotFoundException(404, "Customer Id is not found");
            });
            booking.setCustomer(customer);
        }
        if (request.getStaffId() != null){
            Staff staff = staffRepository.findById(request.getStaffId()).orElseThrow(()->{
                throw new NotFoundException(404, "Staff Id is not found");
            });
            booking.setStaff(staff);
        }
        if (request.getTourId() != null){
            Tour tour = tourRepository.findById(request.getTourId()).orElseThrow(()->{
                throw new NotFoundException(404, "Tour Id is not found");
            });
            booking.setTour(tour);
        }
        if (request.getNumberPerson() != null){
            booking.setNumberPerson(request.getNumberPerson());
        }
        if (request.getTotalPrice() != null){
            booking.setTotalPrice(request.getTotalPrice());
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
}
