package com.fit.Travelo.model;

import com.fit.Travelo.entity.EStatusBooking;
import com.fit.Travelo.entity.Tour;
import com.fit.Travelo.model.response.CustomerBookingRespone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data @Builder
public class BookingDTO {
    private Long id;
    private Integer numberPerson;
    private String status;
    private Double totalPrice;
    private CustomerBookingRespone customer;
    private StaffDTO staff;
    private Tour tour;

}
