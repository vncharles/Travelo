package com.fit.Travelo.controller;

import com.fit.Travelo.model.request.LoginRequest;
import com.fit.Travelo.model.request.RegisterRequest;
import com.fit.Travelo.model.request.ResetPasswordRequest;
import com.fit.Travelo.model.response.JwtResponse;
import com.fit.Travelo.model.response.MessageResponse;
import com.fit.Travelo.service.UserService;
import com.fit.Travelo.service.impl.EmailSenderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final EmailSenderService senderService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest login) {
        return ResponseEntity.ok(userService.login(login.getEmail(), login.getPassword()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest request) {
        userService.create(request);

        return ResponseEntity.ok(new MessageResponse("Register success"));
    }

    @GetMapping("/test-smtp")
    public ResponseEntity<?> testEmail() {
        senderService.sendEmail("tranquoctrong130202@gmail.com", "Test send mail", "This is message test send mail");

        return ResponseEntity.ok(new MessageResponse("Send mail success"));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request) {
        userService.resetPassword(request);

        return ResponseEntity.ok(new MessageResponse("Reset password is success!"));
    }
}
