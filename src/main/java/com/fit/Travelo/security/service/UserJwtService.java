package com.fit.Travelo.security.service;

import com.fit.Travelo.security.jwt.JwtService;
import com.fit.Travelo.security.jwt.UserJwt;
import org.springframework.stereotype.Service;

@Service
public class UserJwtService extends JwtService<UserJwt> {
}