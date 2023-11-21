package com.fit.Travelo.service.impl;

import com.fit.Travelo.entity.Customer;
import com.fit.Travelo.entity.ERole;
import com.fit.Travelo.entity.Role;
import com.fit.Travelo.entity.User;
import com.fit.Travelo.exception.BadRequestException;
import com.fit.Travelo.exception.NotFoundException;
import com.fit.Travelo.model.request.RegisterRequest;
import com.fit.Travelo.model.request.ResetPasswordRequest;
import com.fit.Travelo.model.response.JwtResponse;
import com.fit.Travelo.repository.CustomerRepository;
import com.fit.Travelo.repository.RoleRepository;
import com.fit.Travelo.repository.UserRepository;
import com.fit.Travelo.security.jwt.JwtService;
import com.fit.Travelo.service.UserService;
import com.fit.Travelo.utils.Authen;
import com.fit.Travelo.utils.BcryptUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder encoder;

    private final JwtService jwtService;

    @Override
    public JwtResponse login(String email, String password) {
        System.out.println("Email: " + email);
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new BadRequestException(400, "Email sai định dạng!");
        }

        if(!userRepository.existsByEmail(email)){
            throw new NotFoundException(404, "email has not existed");
        }

        User user = userRepository.findByEmail(email).get();

        if(BcryptUtils.verifyPassword(password, user.getPassword())) {
            String token = jwtService.generateToken(user.getEmail());

            return JwtResponse.builder()
                    .token(token)
                    .type("Bearer")
                    .id(user.getId())
                    .email(user.getEmail())
                    .role(user.getRole().getName().name())
                    .build();
        } else throw new BadRequestException(400, "Incorrect password");
    }

    @Override
    public void create(RegisterRequest request) {
        if(request.getEmail()==null || request.getPassword()==null || request.getName()==null || request.getPhone()==null) {
            throw new BadRequestException(400, "Please input full info");
        }

        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(request.getEmail());
        if (!matcher.matches()) {
            throw new BadRequestException(400, "Email sai định dạng!");
        }

        if(userRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException(400, "Email is exists!");
        }

        Role role = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(()->{
            throw new BadRequestException(400, "Role is not found!");
        });

        User user = User.builder()
                .email(request.getEmail())
                .password(BcryptUtils.hashPassword(request.getPassword()))
                .role(role)
                .active(true)
                .build();

        Customer customer = null;
        try {
            customer = customerRepository.findByEmail(request.getEmail());
        } catch (Exception ex) {

        }

        if(null==customer) {
            customer = Customer.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .phone(request.getPhone())
                    .address(request.getAddress())
                    .user(user)
                    .build();
        } else {
            customer.setName(request.getName());
            customer.setPhone(request.getPhone());
            customer.setAddress(request.getAddress());
            customer.setUser(user);
        }

        customerRepository.save(customer);
    }

    @Override
    public void resetPassword(ResetPasswordRequest request) {
        User user = userRepository.findByEmail(Authen.getEmail()).get();

        if(BcryptUtils.verifyPassword(request.getOldPassword(), user.getPassword())) {
           user.setPassword(BcryptUtils.hashPassword(request.getNewPassword()));

           userRepository.save(user);
        } else throw new BadRequestException(400, "Incorrect old password");
    }


}
