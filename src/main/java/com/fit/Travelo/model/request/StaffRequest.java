package com.fit.Travelo.model.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data @ToString @AllArgsConstructor
public class StaffRequest {
//    @Size(min = 1, max = 100, message = "Full name must be between 1 and 100 characters")
//    @NotBlank(message = "Full name is required")
//    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Input must contain only alphabetic characters (A-Z, a-z) and spaces.")
    private String name;

//    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email is invalid")
//    @NotBlank(message = "Email is required")
    private String email;
    private String phone;
    private String personId;
    private String address;
    private Boolean gender;
    private String birthday;
}
