package com.fit.Travelo.service.impl;

import com.fit.Travelo.entity.Staff;
import com.fit.Travelo.exception.NotFoundException;
import com.fit.Travelo.model.request.StaffRequest;
import com.fit.Travelo.repository.StaffRepository;
import com.fit.Travelo.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    @Override
    public List<Staff> getList() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getDetail(Long id) {
        Staff staff = staffRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException(404, "Staff ID is not found");
        });
        return staff;
    }

    @Override
    public void add(StaffRequest request) {
        Staff staff = new Staff();
        staff.setName(request.getName());
        staff.setEmail(request.getEmail());
        staff.setPhone(request.getPhone());
        staff.setPersonId(request.getPersonId());
        staff.setAddress(request.getAddress());
        staff.setGender(request.getGender());
        staff.setBirthday(request.getBirthday());

        staffRepository.save(staff);
    }

    @Override
    public void update(Long id, StaffRequest request) {
        Staff staff = staffRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException(404, "Location ID is not found");
        });
        if (request.getName() != null){
            staff.setName(request.getName());
        }
        if (request.getEmail() != null){
            staff.setEmail(request.getEmail());
        }
        if (request.getPhone() != null){
            staff.setPhone(request.getPhone());
        }
        if (request.getPersonId() != null){
            staff.setPersonId(request.getPersonId());
        }
        if (request.getAddress() != null){
            staff.setAddress(request.getAddress());
        }
        if (request.getGender() != null){
            staff.setGender(request.getGender());
        }
        if (request.getBirthday() != null){
            staff.setBirthday(request.getBirthday());
        }
        staffRepository.save(staff);
    }

    @Override
    public void delete(Long id) {
        Staff staff = staffRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Staff Id is not found");
        });
        staffRepository.delete(staff);
    }
}
