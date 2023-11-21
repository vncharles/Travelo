package com.fit.Travelo.service.impl;

import com.fit.Travelo.entity.Image;
import com.fit.Travelo.entity.Location;
import com.fit.Travelo.entity.TourInfo;
import com.fit.Travelo.exception.BadRequestException;
import com.fit.Travelo.exception.NotFoundException;
import com.fit.Travelo.model.request.TourInfoRequest;
import com.fit.Travelo.repository.LocationRepository;
import com.fit.Travelo.repository.TourInfoRepository;
import com.fit.Travelo.service.TourInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TourInfoServiceImpl implements TourInfoService {
    private final TourInfoRepository tourInfoRepository;
    private final LocationRepository locationRepository;

    @Value("${pathImage}")
    private String pathImage;

    @Override
    public List<TourInfo> getList() {
        return tourInfoRepository.findAllByStatusIsTrue();
    }

    @Override
    public TourInfo getDetail(Long id) {
        TourInfo tourInfo = tourInfoRepository.findById(id).orElseThrow(() ->{
            throw new NotFoundException(404, "TourInfo id is not found");
        });
        return tourInfo;

    }

    @Override
    public void add(TourInfoRequest request, List<MultipartFile> images) throws IOException {
        Location location = locationRepository.findById(request.getLocationId()).orElseThrow(()->{
            throw new BadRequestException(400, "Location ID is not found!");
        });

        TourInfo tourInfo = new TourInfo();
        tourInfo.setDescription(request.getDescription());
        tourInfo.setName(request.getName());
        tourInfo.setLocation(location);
        tourInfo.setItinerary(request.getItinerary());
        tourInfo.setPrice(request.getPrice());
        tourInfo.setCreateAt(LocalDate.now());
        tourInfo.setStatus(true);

        List<Image> imageList = new ArrayList<>();

        if (images != null) {
            for(MultipartFile image: images) {
                Image newImage = new Image();
                newImage.setTourInfo(tourInfo);
                newImage.setImageUri(pathImage + ImageService.saveImage("images/", image));

                imageList.add(newImage);
            }

        }
        tourInfo.setImages(imageList);
        tourInfoRepository.save(tourInfo);
    }

    @Override
    public void update(Long id, TourInfoRequest request, List<MultipartFile> images) throws IOException {
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
        if(request.getItinerary()!=null) {
            tourInfo.setItinerary(request.getItinerary());
        }

        List<Image> imageList = tourInfo.getImages();
        if(imageList==null) imageList = new ArrayList<>();
        if (images != null) {
            for(MultipartFile image: images) {
                Image newImage = new Image();
                newImage.setTourInfo(tourInfo);
                newImage.setImageUri(pathImage + ImageService.saveImage("images/", image));

                imageList.add(newImage);
            }

        }
        tourInfo.setImages(imageList);

        tourInfoRepository.save(tourInfo);

    }

    @Override
    public void delete(Long id) {
        TourInfo tourInfo = tourInfoRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "TourInfo ID is not found");
        });
        tourInfo.setStatus(false);
        tourInfoRepository.save(tourInfo);
    }
}
