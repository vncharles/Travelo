package com.fit.Travelo.model.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class LocationRequest {
    private String province;
    @Column(length = 500)
    private String description;
}
