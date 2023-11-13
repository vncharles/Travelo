package com.fit.Travelo.controller;

import com.fit.Travelo.entity.Booking;
import com.fit.Travelo.model.request.BookingRequest;
import com.fit.Travelo.service.BookingService;
import com.fit.Travelo.utils.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    public ResponseEntity<List<Booking>> getAll(){
        return ResponseEntity.ok(bookingService.getList());
    }


    public ResponseEntity<Booking> getDetail(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookingService.getDetail(id));
    }


    public ResponseEntity<SuccessResponse> create(@RequestBody BookingRequest request){
        bookingService.add(request);
        return ResponseEntity.ok(new SuccessResponse("Create Booking is success"));
    }

    public ResponseEntity<SuccessResponse> update(@PathVariable("id") Long id,
                                                  @RequestBody BookingRequest request){
        bookingService.update(id, request);
        return ResponseEntity.ok(new SuccessResponse("Create location is success"));
    }

}
