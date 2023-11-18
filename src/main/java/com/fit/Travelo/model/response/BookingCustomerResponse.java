package com.fit.Travelo.model.response;

import com.fit.Travelo.entity.EStatusBooking;
import com.fit.Travelo.entity.Staff;
import com.fit.Travelo.entity.Tour;
import com.fit.Travelo.entity.TourInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingCustomerResponse {
    private Long id;
    private Integer numberPerson;
    private String status;
    private Double totalPrice;
    private Staff staff;
    private TourCustomerResponse tour;
    private TourInfo tourInfo;
}
