package com.fit.Travelo.model.request;

import com.fit.Travelo.entity.EStatusBooking;
import lombok.Data;

@Data
public class BookingRequest {
    private Long customerId;
    private Long staffId;
    private Long tourId;
    private Integer numberPerson;
    private Double totalPrice;
    private EStatusBooking status;
}
