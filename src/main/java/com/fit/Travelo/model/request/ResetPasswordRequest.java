package com.fit.Travelo.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ResetPasswordRequest {
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "A valid password must include at least one lowercase letter (a-z), " +
            "one uppercase letter (A-Z), one digit (0-9), and be a minimum of 8 characters in length.")
    @NotBlank(message = "Password is required")
    private String oldPassword;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "A valid password must include at least one lowercase letter (a-z), " +
            "one uppercase letter (A-Z), one digit (0-9), and be a minimum of 8 characters in length.")
    @NotBlank(message = "Password is required")
    private String newPassword;
}
