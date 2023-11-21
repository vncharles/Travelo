package com.fit.Travelo.service.impl;

import com.fit.Travelo.entity.Tour;
import com.fit.Travelo.entity.TourInfo;
import com.fit.Travelo.exception.BadRequestException;
import com.fit.Travelo.exception.NotFoundException;
import com.fit.Travelo.model.request.TourInfoRequest;
import com.fit.Travelo.model.request.TourRequest;
import com.fit.Travelo.repository.TourInfoRepository;
import com.fit.Travelo.repository.TourRepository;
import com.fit.Travelo.service.TourInfoService;
import com.fit.Travelo.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;
    private final TourInfoService tourInfoService;

    @Override
    public List<Tour> getList() {
        return tourRepository.findAll();
    }

    @Override
    public List<Tour> getListOnSale() {
        return tourRepository.findAllByStartDateAfter(LocalDateTime.now());
    }

    @Override
    public Tour getDetail(Long id) {
        Tour tour = tourRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException(404, "Tour ID is not found");
        });
        return tour;
    }

    @Override
    public void add(TourRequest request) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start =request.getStartDate();
        LocalDateTime end = request.getEndDate();

        if (start.isAfter(end)){
            throw new BadRequestException(400, "Start date must be before End date");
        }

        if(request.getPrice() != null && request.getPrice() <= 0){
            throw new BadRequestException(400, "Price must be gt 0");
        }

        if (request.getStock() != null && request.getStock() <= 0){
            throw new BadRequestException(400, "Stock must be gt 0");
        }



        Tour tour = new Tour();
        TourInfo tourInfo = tourInfoService.getDetail(request.getTourInfoId());
        tour.setTourInfo(tourInfo);
        tour.setCreateAt(LocalDate.now());

        tour.setStartDate(start);
        tour.setEndDate(end);
        tour.setPrice(request.getPrice());
        tour.setStock(request.getStock());
        tourRepository.save(tour);

    }

    @Override
    public void update(Long id, TourRequest request) {
        Tour tour = tourRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException(404, "Tour ID is not found");
        });

        if (request.getTourInfoId() != null){
            tour.setTourInfo(tourInfoService.getDetail(request.getTourInfoId()));
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = tour.getStartDate();
        LocalDateTime end = tour.getEndDate();

        if (request.getStartDate() != null){
            start = request.getStartDate();
        }
        if (request.getEndDate() != null){
            end = request.getEndDate();
        }

        if (start.isAfter(end)){
            throw new BadRequestException(400, "Start date must be before End date");
        }
        tour.setStartDate(start);
        tour.setEndDate(end);

        if(request.getPrice() != null && request.getPrice() <= 0){
            throw new BadRequestException(400, "Price must be gt 0");
        }

        if (request.getStock() != null && request.getStock() <= 0){
            throw new BadRequestException(400, "Stock must be gt 0");
        }

        if (request.getStock() != null){
            tour.setStock(request.getStock());
        }
        if (request.getPrice() != null){
            tour.setPrice(request.getPrice());
        }

        tourRepository.save(tour);
    }

    @Override
    public void delete(Long id) {
        Tour tour = tourRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException(404, "Tour ID is not found");
        });
        tourRepository.delete(tour);
    }
}
