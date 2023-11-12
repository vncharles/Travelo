package com.fit.Travelo.service;

import com.fit.Travelo.entity.Staff;
import com.fit.Travelo.model.request.StaffRequest;
import com.fit.Travelo.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StaffService {
    List<Staff> getList();

    Staff getDetail(Long id);

    void add(StaffRequest request);

    void update(Long id, StaffRequest request);

    void delete(Long id);

}
