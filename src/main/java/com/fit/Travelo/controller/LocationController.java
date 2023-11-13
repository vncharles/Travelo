package com.fit.Travelo.controller;

import com.fit.Travelo.entity.Location;
import com.fit.Travelo.model.request.LocationRequest;
import com.fit.Travelo.service.LocationService;
import com.fit.Travelo.utils.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping("")
    public ResponseEntity<List<Location>> getAll() {

        return ResponseEntity.ok(locationService.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getDetail(@PathVariable("id")Long id) {
        return ResponseEntity.ok(locationService.getDetail(id));
    }

    @PostMapping("")
    public ResponseEntity<SuccessResponse> create(@RequestBody LocationRequest request) {
        locationService.add(request);

        return ResponseEntity.ok(new SuccessResponse("Create location is success"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse> update(@PathVariable("id")Long id,
                                    @RequestBody LocationRequest request) {
        locationService.update(id, request);

        return ResponseEntity.ok(new SuccessResponse("Update location is success"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> delete(@PathVariable("id")Long id) {
        locationService.delete(id);

        return ResponseEntity.ok(new SuccessResponse("Delete location is success"));
    }
}
