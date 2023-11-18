package com.fit.Travelo.security.service;

import com.fit.Travelo.entity.User;
import com.fit.Travelo.exception.NotFoundException;
import com.fit.Travelo.mapper.UserMapper;
import com.fit.Travelo.repository.UserRepository;
import com.fit.Travelo.security.jwt.UserJwt;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
@Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    throw new NotFoundException(404, "User is not found!");
                });

//        CustomUserDetails userDetail = CustomUserDetails.create(user);
        return UserDetailsImpl.build(user);
    }
}
