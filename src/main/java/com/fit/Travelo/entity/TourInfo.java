package com.fit.Travelo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_tour_info")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TourInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 500)
    private String description;
    private LocalDate createAt;
    private Double price;
    @Column(length = 10000)
    private String itinerary;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Image> images;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
