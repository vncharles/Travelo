package com.fit.Travelo.service.impl;

import com.fit.Travelo.entity.ERole;
import com.fit.Travelo.entity.Role;
import com.fit.Travelo.entity.Staff;
import com.fit.Travelo.entity.User;
import com.fit.Travelo.exception.BadRequestException;
import com.fit.Travelo.exception.NotFoundException;
import com.fit.Travelo.model.request.StaffRequest;
import com.fit.Travelo.repository.RoleRepository;
import com.fit.Travelo.repository.StaffRepository;
import com.fit.Travelo.service.StaffService;
import com.fit.Travelo.utils.BcryptUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final RoleRepository roleRepository;
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
        if(null==request.getName() || null==request.getEmail() ||
            null==request.getPhone() || null==request.getPersonId() ||
            null==request.getAddress() || null==request.getGender()) {
            throw new BadRequestException(400, "Please input full info");
        }

        Role role = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(()->{
            throw new BadRequestException(400, "Role is not found!");
        });

        User user = User.builder()
                .email(request.getEmail())
                .password(BcryptUtils.hashPassword(request.getEmail()))
                .role(role)
                .build();

        Staff staff = new Staff();
        staff.setName(request.getName());
        staff.setEmail(request.getEmail());
        staff.setPhone(request.getPhone());
        staff.setPersonId(request.getPersonId());
        staff.setAddress(request.getAddress());
        staff.setGender(request.getGender());
        staff.setUser(user);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        staff.setBirthday(LocalDate.parse(request.getBirthday(), format));

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
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            staff.setBirthday(LocalDate.parse(request.getBirthday(), format));
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
