package com.fit.Travelo.repository;

import com.fit.Travelo.entity.Booking;
import com.fit.Travelo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query(nativeQuery = true, value = "select * from t_booking where customer_id=?1")
    List<Booking> findAllByCustomer(Long id);

    List<Booking> findByCustomer(Customer customer);

    List<Booking> findByCustomer_EmailOrderByCreatedAtDesc(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM `travelo-app`.t_booking order by `created_at` DESC;")
    List<Booking> findAllOrderByCreatedAtDesc();
}
