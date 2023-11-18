package com.fit.Travelo.mapper;

import com.fit.Travelo.entity.Booking;
import com.fit.Travelo.model.BookingDTO;

public class BookingMapper {
    public static BookingDTO bookingToBookingDTO(Booking booking){

        return BookingDTO.builder()
                .id(booking.getId())
                .numberPerson(booking.getNumberPerson())
                .status(booking.getStatus().name())
                .totalPrice(booking.getTotalPrice())
                .customer(CustomerMapper.customerToCustomerBookingResponse(booking.getCustomer()))
                .staff(StaffMapper.staffToStaffBookingResponse(booking.getStaff()))
                .tour(booking.getTour())
                .build();
    }
}
