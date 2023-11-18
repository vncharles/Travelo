package com.fit.Travelo.mapper;

import com.fit.Travelo.entity.Staff;
import com.fit.Travelo.model.StaffDTO;

public class StaffMapper {
    public static StaffDTO staffToStaffBookingResponse(Staff staff) {
        if (staff == null) return null;
        return StaffDTO.builder()
                .id(staff.getId())
                .name(staff.getName())
                .email(staff.getEmail())
                .phone(staff.getPhone())
                .address(staff.getAddress())
                .gender(staff.getGender())
                .birthday(staff.getBirthday())
                .build();

    }
}
