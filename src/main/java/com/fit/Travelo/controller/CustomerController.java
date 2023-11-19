package com.fit.Travelo.controller;

import com.fit.Travelo.entity.Customer;
import com.fit.Travelo.model.CustomerDTO;
import com.fit.Travelo.model.request.CustomerRequest;
import com.fit.Travelo.service.CustomerService;
import com.fit.Travelo.utils.SuccessResponse;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<CustomerDTO>> getAll(){
        return ResponseEntity.ok(customerService.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getDetail(@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.getDetail(id));
    }

    @PostMapping("")
    public ResponseEntity<SuccessResponse> create(@RequestBody CustomerRequest request){
        customerService.add(request);
        return ResponseEntity.ok(new SuccessResponse(("create new customer is successful")));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse> update(@PathVariable("id") Long id,
                                                  @RequestBody CustomerRequest request){
        customerService.update(id, request);
        return ResponseEntity.ok(new SuccessResponse(("update Customer is successful")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> delete(@PathVariable("id") Long id){
        customerService.delete(id);
        return ResponseEntity.ok(new SuccessResponse(("delete Customer is successful")));
    }

    @GetMapping("/detail-person")
    public ResponseEntity<?> getDetailPerson() {
        return null;
    }

}
