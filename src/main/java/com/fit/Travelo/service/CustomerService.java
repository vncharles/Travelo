package com.fit.Travelo.service;

import com.fit.Travelo.entity.Customer;
import com.fit.Travelo.model.request.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> getList();

    Customer getDetail(Long id);

    void add(CustomerRequest request);

    void update(Long id, CustomerRequest request);

    void delete(Long id);
}
