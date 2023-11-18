package com.fit.Travelo.service.impl;

import com.fit.Travelo.entity.ERole;
import com.fit.Travelo.exception.BadRequestException;
import com.fit.Travelo.exception.NotFoundException;
import com.fit.Travelo.model.response.JwtResponse;
import com.fit.Travelo.repository.RoleRepository;
import com.fit.Travelo.repository.UserRepository;
import com.fit.Travelo.security.jwt.JwtService;
import com.fit.Travelo.security.service.UserDetailsImpl;
import com.fit.Travelo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public JwtResponse login(String email, String password) {
        if(!userRepository.existsByEmail(email)){
            throw new NotFoundException(404, "email has not existed");
        }

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtService.generateToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            String roles = String.valueOf(userDetails.getAuthorities().stream().collect(Collectors.toList()).get(0));

            return new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    roles);
        } catch (Exception ex){
            throw new BadRequestException(400, "wrong password");
        }
    }


}
