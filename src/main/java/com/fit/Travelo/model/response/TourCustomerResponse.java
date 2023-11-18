package com.fit.Travelo.model.response;

import com.fit.Travelo.entity.TourInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TourCustomerResponse {
    private Long id;
    private LocalDate createAt;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;
    private Integer stock;
    private TourInfo tourInfo;
}
