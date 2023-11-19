package com.fit.Travelo.service.impl;

import com.fit.Travelo.entity.Customer;
import com.fit.Travelo.exception.BadRequestException;
import com.fit.Travelo.exception.NotFoundException;
import com.fit.Travelo.mapper.CustomerMapper;
import com.fit.Travelo.model.CustomerDTO;
import com.fit.Travelo.model.request.CustomerRequest;
import com.fit.Travelo.repository.BookingRepository;
import com.fit.Travelo.repository.CustomerRepository;
import com.fit.Travelo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final BookingRepository bookingRepository;

    @Override
    public List<CustomerDTO> getList() {
        List<Customer> list = customerRepository.findAll();

        return list.stream().map((customer)->{
            customer.setBookings(bookingRepository.findByCustomer(customer));

            return CustomerMapper.customerToCustomerDTO(customer);
        }).collect(Collectors.toList());
    }

    @Override
    public Customer getDetail(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Customer Id is not found");
        });
        return customer;
    }

    @Override
    public Customer getDetailByEmail(String email) {
        return customerRepository.findByEmail(email);

    }

    @Override
    public void add(CustomerRequest request) {
        if (request.getEmail() == null || request.getName() == null){
            throw new BadRequestException(400, "email and name need be required");
        }
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone() != null ? request.getPhone() : null);
        customer.setAddress(request.getAddress() != null ? request.getAddress() : null);
        customerRepository.save(customer);
    }

    @Override
    public void update(Long id, CustomerRequest request) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Customer Id isn't found");
        });
        if (request.getName() != null){
            customer.setName(request.getName());
        }
        if (request.getEmail() != null){
            customer.setEmail(request.getEmail());
        }
        if (request.getPhone() != null){
            customer.setPhone(request.getPhone());
        }
        if (request.getAddress() != null){
            customer.setAddress(request.getAddress());
        }
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Customer Id isn't found");
        });
        customerRepository.delete(customer);
    }
}
