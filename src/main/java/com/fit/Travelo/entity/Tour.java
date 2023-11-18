package com.fit.Travelo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_tour")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate createAt;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;
    private Integer stock;
    @ManyToOne
    @JoinColumn(name = "tour_info_id")
    private TourInfo tourInfo;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<Booking> bookings;

    public void increaseStock(int quantity) {
        stock += quantity;
    }

    public void decreaseStock(int quantity) {
        stock -= quantity;
    }
}
