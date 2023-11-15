package com.fit.Travelo.controller;

import com.fit.Travelo.entity.Booking;
import com.fit.Travelo.model.request.BookingRequest;
import com.fit.Travelo.service.BookingService;
import com.fit.Travelo.utils.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Booking>> getAll(){
        return ResponseEntity.ok(bookingService.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getDetail(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookingService.getDetail(id));
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> create(@RequestBody BookingRequest request){
        bookingService.add(request);
        return ResponseEntity.ok(new SuccessResponse("Create Booking is success"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse> update(@PathVariable("id") Long id,
                                                  @RequestBody BookingRequest request){
        bookingService.update(id, request);
        return ResponseEntity.ok(new SuccessResponse("update booking is success"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> delete(@PathVariable("id") Long id){
        bookingService.delete(id);
        return ResponseEntity.ok(new SuccessResponse("delete booking is success"));
    }

}
