package com.fit.Travelo.model.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StaffRequest {
    private String name;
    private String email;
    private String phone;
    private String personId;
    private String address;
    private Boolean gender;
    private LocalDate birthday;
}
