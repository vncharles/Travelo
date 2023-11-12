package com.fit.Travelo.service;

import com.fit.Travelo.entity.Booking;
import com.fit.Travelo.entity.Location;
import com.fit.Travelo.model.request.BookingRequest;
import com.fit.Travelo.model.request.LocationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    List<Booking> getList();

    Booking getDetail(Long id);

    void add(BookingRequest request);

    void update(Long id, BookingRequest request);

    void delete(Long id);
}
