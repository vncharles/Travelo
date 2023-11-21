package com.fit.Travelo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fit.Travelo.entity.TourInfo;
import com.fit.Travelo.model.request.TourInfoRequest;
import com.fit.Travelo.service.TourInfoService;
import com.fit.Travelo.utils.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/tour-info")
@RequiredArgsConstructor
public class TourInfoController {
    private final TourInfoService tourInfoService;

    @GetMapping("")
    public ResponseEntity<List<TourInfo>> getAll(){

        return ResponseEntity.ok(tourInfoService.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourInfo> getDetail(@PathVariable("id") Long id){
        return ResponseEntity.ok(tourInfoService.getDetail(id));
    }

    @PostMapping("")
    public ResponseEntity<SuccessResponse> create(@RequestParam(value = "data", required = false) String data,
                                                  @RequestParam("images") List<MultipartFile> image) throws IOException {
        TourInfoRequest request = null;
        if(data!=null) {
            ObjectMapper mapper = new ObjectMapper();
            request = mapper.readValue(data, TourInfoRequest.class);
        } else request = new TourInfoRequest();

        tourInfoService.add(request, image);
        return ResponseEntity.ok(new SuccessResponse("Create tour info is success"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse> update(@PathVariable("id") Long id,
                                                  @RequestParam(value = "data", required = false) String data,
                                                  @RequestParam(value = "images", required = false) List<MultipartFile> image) throws IOException {
        TourInfoRequest request = null;
        if(data!=null) {
            ObjectMapper mapper = new ObjectMapper();
            request = mapper.readValue(data, TourInfoRequest.class);
        } else request = new TourInfoRequest();

        tourInfoService.update(id, request, image);

        return ResponseEntity.ok(new SuccessResponse("Update tour info is success"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> delete (@PathVariable("id") Long id){
        tourInfoService.delete(id);
        return ResponseEntity.ok(new SuccessResponse("Delete tour info is success"));
    }
}
