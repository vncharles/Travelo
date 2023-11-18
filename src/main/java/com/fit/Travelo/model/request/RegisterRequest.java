package com.fit.Travelo.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RegisterRequest {
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
}
