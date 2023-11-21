package com.fit.Travelo.model.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fit.Travelo.entity.EStatusBooking;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingRequest {
    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email is invalid")
    @NotBlank(message = "Email is required")
    private String email;
    @Size(min = 1, max = 100, message = "Full name must be between 1 and 100 characters")
    @NotBlank(message = "Full name is required")
    private String name;
    private String phone;
    private String address;
    private Long tourId;
    private Integer numberPerson;
    private EStatusBooking status;
}
