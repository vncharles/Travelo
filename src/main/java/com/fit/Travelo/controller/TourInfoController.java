package com.fit.Travelo.controller;

import com.fit.Travelo.entity.TourInfo;
import com.fit.Travelo.model.request.TourInfoRequest;
import com.fit.Travelo.service.TourInfoService;
import com.fit.Travelo.utils.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourinfo")
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
    public ResponseEntity<SuccessResponse> create(@RequestBody TourInfoRequest request){
        tourInfoService.add(request);
        return ResponseEntity.ok(new SuccessResponse("Create tour info is success"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse> update(@PathVariable("id") Long id,
                                                  @RequestBody TourInfoRequest request){
        tourInfoService.update(id, request);
        return ResponseEntity.ok(new SuccessResponse("Update tour info is success"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> delete (@PathVariable("id") Long id){
        tourInfoService.delete(id);
        return ResponseEntity.ok(new SuccessResponse("Delete tour info is success"));
    }
}
