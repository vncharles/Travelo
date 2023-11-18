package com.fit.Travelo.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerBookingRespone {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
