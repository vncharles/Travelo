package com.fit.Travelo.controller;

import com.fit.Travelo.model.request.LoginRequest;
import com.fit.Travelo.model.request.RegisterRequest;
import com.fit.Travelo.model.response.JwtResponse;
import com.fit.Travelo.model.response.MessageResponse;
import com.fit.Travelo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest login) {
        return ResponseEntity.ok(userService.login(login.getEmail(), login.getPassword()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        userService.create(request);

        return ResponseEntity.ok(new MessageResponse("Register success"));
    }

}
