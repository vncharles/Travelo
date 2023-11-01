package com.fit.Travelo.service;

import com.fit.Travelo.entity.Location;
import com.fit.Travelo.model.request.LocationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {
    List<Location> getList();

    Location getDetail(Long id);

    void add(LocationRequest request);

    void update(Long id, LocationRequest request);

    void delete(Long id);

}
