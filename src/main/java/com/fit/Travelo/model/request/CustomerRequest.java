package com.fit.Travelo.model.request;

import lombok.Data;

@Data
public class CustomerRequest {
    private String name;
    private String email;
    private String phone;
    private String address;
}
