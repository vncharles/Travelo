package com.fit.Travelo.controller;

import com.fit.Travelo.entity.Staff;
import com.fit.Travelo.exception.BadRequestException;
import com.fit.Travelo.model.StaffDTO;
import com.fit.Travelo.model.request.StaffRequest;
import com.fit.Travelo.service.StaffService;
import com.fit.Travelo.utils.SuccessResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @GetMapping("")
    public ResponseEntity<List<StaffDTO>> getAll(){
        return ResponseEntity.ok(staffService.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffDTO> getDetail(@PathVariable("id") Long id) {
        return ResponseEntity.ok(staffService.getDetail(id));
    }

    @PostMapping("")
    public ResponseEntity<SuccessResponse> create(@Valid @RequestBody StaffRequest request){
        staffService.add(request);
        return ResponseEntity.ok(new SuccessResponse("create new staff is successful"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse> update(@PathVariable("id") Long id,
                                                  @Valid @RequestBody StaffRequest request){
        staffService.update(id, request);
        return ResponseEntity.ok(new SuccessResponse("update staff is successful"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> delete(@PathVariable("id")String id){
        staffService.delete(Long.parseLong(id));
        return ResponseEntity.ok(new SuccessResponse(("delete staff is successful")));
    }


}
