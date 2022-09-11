package com.zetta.springexperiments.service;

import com.zetta.springexperiments.security.InternalUser;
import com.zetta.springexperiments.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        InternalUser user = userRepository.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        var builder =
                org.springframework.security.core.userdetails.
                        User.withUsername(username);
        builder.password(user.getPassword());
        builder.roles(user.getRole());
        return builder.build();

    }
}
