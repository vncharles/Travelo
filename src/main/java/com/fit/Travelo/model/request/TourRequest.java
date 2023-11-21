package com.fit.Travelo.model.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TourRequest {
    private Long tourInfoId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;
    private Integer stock;

}
