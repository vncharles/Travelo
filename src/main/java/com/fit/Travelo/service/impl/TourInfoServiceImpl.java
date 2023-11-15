package com.fit.Travelo.service.impl;

import com.fit.Travelo.entity.Location;
import com.fit.Travelo.entity.TourInfo;
import com.fit.Travelo.exception.NotFoundException;
import com.fit.Travelo.model.request.TourInfoRequest;
import com.fit.Travelo.repository.LocationRepository;
import com.fit.Travelo.repository.TourInfoRepository;
import com.fit.Travelo.service.TourInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourInfoServiceImpl implements TourInfoService {
    private final TourInfoRepository tourInfoRepository;
    private final LocationRepository locationRepository;
    @Override
    public List<TourInfo> getList() {
        return tourInfoRepository.findAll();
    }

    @Override
    public TourInfo getDetail(Long id) {
        TourInfo tourInfo = tourInfoRepository.findById(id).orElseThrow(() ->{
            throw new NotFoundException(404, "TourInfo id is not found");
        });
        return tourInfo;





    }

    @Override
    public void add(TourInfoRequest request) {
        TourInfo tourInfo = new TourInfo();
        tourInfo.setDescription(request.getDescription());
        tourInfo.setName(request.getName());

        Location location = locationRepository.findById(request.getLocationId()).get();
        tourInfo.setLocation(location);
        tourInfoRepository.save(tourInfo);

    }

    @Override
    public void update(Long id, TourInfoRequest request) {
        TourInfo tourInfo = tourInfoRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException(404, "TourInfo ID is not found");
        });

        if (request.getName() != null){
            tourInfo.setName(request.getName());
        }

        if (request.getPrice() != null){
            tourInfo.setPrice(request.getPrice());
        }

        if (request.getDescription() != null){
            tourInfo.setDescription(request.getDescription());
        }

        if (request.getLocationId() != null){
            Location location = locationRepository.findById(request.getLocationId()).get();
            tourInfo.setLocation(location);
        }

        tourInfoRepository.save(tourInfo);

    }

    @Override
    public void delete(Long id) {
        TourInfo tourInfo = tourInfoRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "TourInfo ID is not found");
        });
        tourInfoRepository.delete(tourInfo);
    }
}
