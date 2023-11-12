package com.fit.Travelo.service.impl;

import com.fit.Travelo.entity.Location;
import com.fit.Travelo.exception.NotFoundException;
import com.fit.Travelo.model.request.LocationRequest;
import com.fit.Travelo.repository.LocationRepository;
import com.fit.Travelo.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public List<Location> getList() {

        return locationRepository.findAll();
    }

    @Override
    public Location getDetail(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Location ID is not found");
        });

        return location;
    }

    @Override
    public void add(LocationRequest request) {
        Location location = new Location();
        location.setDescription(request.getDescription());
        location.setProvince(request.getProvince());
        locationRepository.save(location);
    }

    @Override
    public void update(Long id, LocationRequest request) {
        Location location = locationRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Location ID is not found");
        });

        if(null!=request.getProvince()) {
            location.setProvince(request.getProvince());
        }
        if(null!=request.getDescription()) {
            location.setDescription(request.getDescription());
        }

        locationRepository.save(location);
    }

    @Override
    public void delete(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Location ID is not found");
        });

        locationRepository.delete(location);
    }
}
