package com.fit.Travelo.service;

import com.fit.Travelo.entity.Tour;
import com.fit.Travelo.entity.TourInfo;
import com.fit.Travelo.model.request.TourInfoRequest;
import com.fit.Travelo.model.request.TourRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TourService {
    List<Tour> getList();

    Tour getDetail(Long id);

    void add(TourRequest request);

    void update(Long id, TourRequest request);

    void delete(Long id);

}
