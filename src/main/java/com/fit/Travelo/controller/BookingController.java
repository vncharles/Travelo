package com.fit.Travelo.controller;

import com.fit.Travelo.entity.Booking;
import com.fit.Travelo.model.BookingDTO;
import com.fit.Travelo.model.request.BookingRequest;
import com.fit.Travelo.service.BookingService;
import com.fit.Travelo.utils.SuccessResponse;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<BookingDTO>> getAll(){
        return ResponseEntity.ok(bookingService.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getDetail(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookingService.getDetail(id));
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> customerCreate(@RequestBody BookingRequest request){
        bookingService.addByCustomer(request);
        return ResponseEntity.ok(new SuccessResponse("Create Booking is success"));
    }

    @PostMapping("/staff-create")
    public ResponseEntity<SuccessResponse> staffCreate(@RequestBody BookingRequest request){
        bookingService.addByStaff(request);
        return ResponseEntity.ok(new SuccessResponse("Create Booking by Staff is success"));
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

    @GetMapping("/list-by-email")
    public ResponseEntity<?> getListByEmail(@RequestParam("email")String email){
        return ResponseEntity.ok(bookingService.getListByEmail(email));
    }
}
