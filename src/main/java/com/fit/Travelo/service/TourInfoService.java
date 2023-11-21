package com.fit.Travelo.service;

import com.fit.Travelo.entity.Location;
import com.fit.Travelo.entity.TourInfo;
import com.fit.Travelo.model.request.LocationRequest;
import com.fit.Travelo.model.request.TourInfoRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface TourInfoService {
    List<TourInfo> getList();

    TourInfo getDetail(Long id);

    void add(TourInfoRequest request, List<MultipartFile> images) throws IOException;

    void update(Long id, TourInfoRequest request, List<MultipartFile> images) throws IOException;

    void delete(Long id);
}
