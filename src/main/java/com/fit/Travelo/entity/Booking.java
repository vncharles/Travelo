package com.fit.Travelo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_booking")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numberPerson;
    private LocalDate createdAt;
    @Enumerated(EnumType.STRING)
    private EStatusBooking status;
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;


    private void setTotalPrice(){
        totalPrice = tour.getPrice() * numberPerson;
    }

    public Double getTotalPrice(){
        setTotalPrice();
        return totalPrice;
    }
}
