package com.fit.Travelo.repository;

import com.fit.Travelo.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query(nativeQuery = true, value = "select * from t_booking where customer_id=?1")
    List<Booking> findAllByCustomer(Long id);
}
