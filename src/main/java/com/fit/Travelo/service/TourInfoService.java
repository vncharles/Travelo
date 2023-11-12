package com.fit.Travelo.service;

import com.fit.Travelo.entity.Location;
import com.fit.Travelo.entity.TourInfo;
import com.fit.Travelo.model.request.LocationRequest;
import com.fit.Travelo.model.request.TourInfoRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TourInfoService {
    List<TourInfo> getList();

    TourInfo getDetail(Long id);

    void add(TourInfoRequest request);

    void update(Long id, TourInfoRequest request);

    void delete(Long id);
}
