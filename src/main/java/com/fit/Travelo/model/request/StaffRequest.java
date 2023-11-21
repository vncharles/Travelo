package com.fit.Travelo.model.request;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
@Data
public class StaffRequest {
    @Size(min = 1, max = 100, message = "Full name must be between 1 and 100 characters")
    @NotBlank(message = "Full name is required")
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email is invalid")
    @NotBlank(message = "Email is required")
    private String email;
    private String phone;
    private String personId;
    private String address;
    private Boolean gender;
    private LocalDate birthday;
}

