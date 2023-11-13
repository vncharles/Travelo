package com.fit.Travelo.controller;

import com.fit.Travelo.entity.Tour;
import com.fit.Travelo.entity.TourInfo;
import com.fit.Travelo.model.request.TourRequest;
import com.fit.Travelo.service.TourService;
import com.fit.Travelo.utils.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tour")
@RequiredArgsConstructor
public class TourController {
    private final TourService tourService;

    @GetMapping("")
    public ResponseEntity<List<Tour>> getAll(){
        return ResponseEntity.ok(tourService.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tour> getDetail(@PathVariable("id") Long id){
        return ResponseEntity.ok(tourService.getDetail(id));
    }

    @PostMapping("")
    public ResponseEntity<SuccessResponse> create(@RequestBody TourRequest request){
        tourService.add(request);
        return ResponseEntity.ok(new SuccessResponse("Create Tour is success"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse> update(@PathVariable("id")Long id,
                                                  @RequestBody TourRequest request){
        tourService.update(id, request);
        return ResponseEntity.ok(new SuccessResponse("update Tour is success"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> delete(@PathVariable("id") Long id){
        tourService.delete(id);
        return ResponseEntity.ok(new SuccessResponse(("deleted tour is success")));
    }

}
