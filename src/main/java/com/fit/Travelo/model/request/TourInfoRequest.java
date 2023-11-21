package com.fit.Travelo.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor
public class TourInfoRequest {
    private String name;
    private String description;
    private Double price;
    private String itinerary;
    private Long locationId;
}
