package com.fit.Travelo.security;


import com.fit.Travelo.entity.ERole;
import com.fit.Travelo.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
        http.cors(cors -> cors.disable());
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(request -> request
                .requestMatchers(HttpMethod.GET, "/staff/{id}").hasAnyAuthority(ERole.ROLE_ADMIN.name(), ERole.ROLE_STAFF.name())
                .requestMatchers("/staff/**").hasAnyAuthority(ERole.ROLE_ADMIN.name())
                .requestMatchers(HttpMethod.GET, "/booking/**").hasAnyAuthority(ERole.ROLE_STAFF.name(), ERole.ROLE_ADMIN.name())
                .requestMatchers("/booking/list-by-email").permitAll()
                .requestMatchers("/booking/**").hasAnyAuthority(ERole.ROLE_STAFF.name(), ERole.ROLE_ADMIN.name())
                .requestMatchers(HttpMethod.GET, "/customer/detail-person").hasAnyAuthority(ERole.ROLE_STAFF.name(), ERole.ROLE_ADMIN.name())
                .requestMatchers("/customer/**").hasAnyAuthority(ERole.ROLE_STAFF.name(), ERole.ROLE_ADMIN.name())
                .requestMatchers(HttpMethod.GET, "/location", "/location/{id}").permitAll()
                .requestMatchers("/location/**").hasAnyAuthority(ERole.ROLE_STAFF.name(), ERole.ROLE_ADMIN.name())
                .requestMatchers(HttpMethod.GET, "/tour", "/tour/{id}").permitAll()
                .requestMatchers("/tour/**").hasAnyAuthority(ERole.ROLE_STAFF.name(), ERole.ROLE_ADMIN.name())
                .requestMatchers("/tour-info/**").hasAnyAuthority(ERole.ROLE_STAFF.name(), ERole.ROLE_ADMIN.name())
                .requestMatchers("/**").permitAll()
               .anyRequest().authenticated()
        ).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.httpBasic(Customizer.withDefaults());

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService); //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
        return auth;
    }


}
