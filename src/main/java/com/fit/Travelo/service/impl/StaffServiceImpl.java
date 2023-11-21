package com.fit.Travelo.service.impl;

import com.fit.Travelo.entity.ERole;
import com.fit.Travelo.entity.Role;
import com.fit.Travelo.entity.Staff;
import com.fit.Travelo.entity.User;
import com.fit.Travelo.exception.BadRequestException;
import com.fit.Travelo.exception.NotFoundException;
import com.fit.Travelo.mapper.StaffMapper;
import com.fit.Travelo.model.StaffDTO;
import com.fit.Travelo.model.request.StaffRequest;
import com.fit.Travelo.repository.RoleRepository;
import com.fit.Travelo.repository.StaffRepository;
import com.fit.Travelo.repository.UserRepository;
import com.fit.Travelo.service.StaffService;
import com.fit.Travelo.utils.BcryptUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    @Override
    public List<StaffDTO> getList() {
        List<Staff> staffList = staffRepository.findAll();

        return staffList.stream().map(staff -> {
            return StaffDTO.builder()
                    .id(staff.getId())
                    .name(staff.getName())
                    .email(staff.getEmail())
                    .phone(staff.getPhone())
                    .personId(staff.getPersonId())
                    .address(staff.getAddress())
                    .gender(staff.getGender())
                    .birthday(staff.getBirthday())
                    .statusWorking(staff.getStatusWorking())
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public StaffDTO getDetail(Long id) {
        Staff staff = staffRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException(404, "Staff ID is not found");
        });
        return StaffDTO.builder()
                .id(staff.getId())
                .name(staff.getName())
                .email(staff.getEmail())
                .phone(staff.getPhone())
                .personId(staff.getPersonId())
                .address(staff.getAddress())
                .gender(staff.getGender())
                .birthday(staff.getBirthday())
                .statusWorking(staff.getStatusWorking())
                .build();
    }

    @Override
    public Staff findByEmail(String email) {
        return staffRepository.findStaffByEmail(email);
    }

    @Override
    public void add(StaffRequest request) {
        if(null==request.getName() || null==request.getEmail() ||
            null==request.getPhone() || null==request.getPersonId() ||
            null==request.getAddress() || null==request.getGender()) {
            throw new BadRequestException(400, "Please input full info");
        }

        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(request.getEmail());
        if (!matcher.matches()) {
            throw new BadRequestException(400, "Email sai định dạng!");
        }

        pattern = Pattern.compile("^(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})$");
        matcher = pattern.matcher(request.getPhone());
        if(!matcher.matches()) {
            throw new BadRequestException(400, "Số điện thoại sai định dạng");
        }

        pattern = Pattern.compile("^\\d{9,12}$");
        matcher = pattern.matcher(request.getPersonId());
        if(!matcher.matches()) {
            throw new BadRequestException(400, "Căn cước công dân sai định dạng");
        }

        Role role = roleRepository.findByName(ERole.ROLE_STAFF).orElseThrow(()->{
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
        staff.setStatusWorking(true);
        staff.setUser(user);
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
        if (request.getPhone() != null){
            Pattern pattern = Pattern.compile("^(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})$");
            Matcher matcher = pattern.matcher(request.getPhone());
            if(!matcher.matches()) {
                throw new BadRequestException(400, "Số điện thoại sai định dạng");
            }

            staff.setPhone(request.getPhone());
        }
        if (request.getPersonId() != null){
            if(request.getPersonId().length()!=12) {
                throw new BadRequestException(400, "Căn cước công dân sai định dạng");
            }
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
            staff.setBirthday(request.getBirthday());
        }
        staffRepository.save(staff);
    }

    @Override
    public void delete(Long id) {
        Staff staff = staffRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(404, "Staff Id is not found");
        });
        staff.setStatusWorking(false);
        staff.setUser(null);
        staffRepository.save(staff);

        try {
            User user = userRepository.findByEmail(staff.getEmail()).get();
            user.setActive(false);

            userRepository.delete(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }
}
