package com.fit.Travelo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StaffDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String personId;
    private String address;
    private Boolean gender;
    private LocalDate birthday;
    private Boolean statusWorking;
}
