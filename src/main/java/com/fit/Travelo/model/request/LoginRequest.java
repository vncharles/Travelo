package com.fit.Travelo.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LoginRequest {
    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email is invalid")
    @NotBlank(message = "Email is required")
    private String email;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "A valid password must include at least one lowercase letter (a-z), " +
            "one uppercase letter (A-Z), one digit (0-9), and be a minimum of 8 characters in length.")
    @NotBlank(message = "Password is required")
    private String password;
}
