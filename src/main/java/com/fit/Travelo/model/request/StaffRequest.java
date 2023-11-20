package com.fit.Travelo.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;


@Data @AllArgsConstructor @NoArgsConstructor
public class StaffRequest {
    private String name;
    private String email;
    private String phone;
    private String personId;
    private String address;
    private Boolean gender;
    private LocalDate birthday;
}

