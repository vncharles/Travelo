package com.fit.Travelo.model.request;

import com.fit.Travelo.entity.EStatusBooking;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingRequest {
    private String email;
    private String name;
    private String phone;
    private String address;
    private Long staffId;
    private Long tourId;
    private Integer numberPerson;
    private EStatusBooking status;
}
