package com.fit.Travelo.security.service;

import com.fit.Travelo.entity.Account;
import com.fit.Travelo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(username);
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        if(account ==null) throw new UsernameNotFoundException("User Not Found with username: " + username);
        return UserDetailsImpl.build(account);
    }

}
