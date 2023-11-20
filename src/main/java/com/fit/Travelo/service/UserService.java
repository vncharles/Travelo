package com.fit.Travelo.service;

import com.fit.Travelo.entity.ERole;
import com.fit.Travelo.model.request.RegisterRequest;
import com.fit.Travelo.model.request.ResetPasswordRequest;
import com.fit.Travelo.model.response.JwtResponse;

public interface UserService {
    JwtResponse login(String email, String password);

    void create(RegisterRequest registerRequest);

    void resetPassword(ResetPasswordRequest request);
}
