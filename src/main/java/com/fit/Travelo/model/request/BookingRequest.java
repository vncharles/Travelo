package com.fit.Travelo.model.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fit.Travelo.entity.EStatusBooking;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor
public class BookingRequest {
    private String email;
    private String name;
    private String phone;
    private String address;
    private Long tourId;
    private Integer numberPerson;
    private String status;
}
