package com.fit.Travelo.service;

import com.fit.Travelo.entity.Staff;
import com.fit.Travelo.model.StaffDTO;
import com.fit.Travelo.model.request.StaffRequest;
import com.fit.Travelo.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StaffService {
    List<StaffDTO> getList();

    StaffDTO getDetail(Long id);

    Staff findByEmail(String email);

    void add(StaffRequest request);

    void update(Long id, StaffRequest request);

    void delete(Long id);

}
