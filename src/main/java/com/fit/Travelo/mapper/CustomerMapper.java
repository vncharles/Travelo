package com.fit.Travelo.mapper;

import com.fit.Travelo.entity.Customer;
import com.fit.Travelo.entity.Tour;
import com.fit.Travelo.model.CustomerDTO;
import com.fit.Travelo.model.response.BookingCustomerResponse;
import com.fit.Travelo.model.response.CustomerBookingRespone;
import com.fit.Travelo.model.response.TourCustomerResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {
    public static CustomerDTO customerToCustomerDTO(Customer customer) {
        List<BookingCustomerResponse> bookings = customer.getBookings().stream().map((booking -> {
            return BookingCustomerResponse.builder()
                    .id(booking.getId())
                    .numberPerson(booking.getNumberPerson())
                    .status(booking.getStatus().name())
                    .totalPrice(booking.getTotalPrice())
                    .staff(booking.getStaff())
                    .tour(toTourCustomerResponse(booking.getTour()))

                    .build();
        })).collect(Collectors.toList());

        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .bookings(bookings)
                .build();
    }

    private static TourCustomerResponse toTourCustomerResponse(Tour tour) {
        return TourCustomerResponse.builder()
                .id(tour.getId())
                .createAt(tour.getCreateAt())
                .startDate(tour.getStartDate())
                .endDate(tour.getEndDate())
                .price(tour.getPrice())
                .stock(tour.getStock())
                .tourInfo(tour.getTourInfo())
                .build();
    }

    public static CustomerBookingRespone customerToCustomerBookingResponse(Customer customer) {

        return  CustomerBookingRespone.builder()
                .id(customer.getId())
                .name(customer.getName())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .build();
    }
}
