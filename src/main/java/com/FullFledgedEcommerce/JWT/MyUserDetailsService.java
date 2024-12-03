package com.FullFledgedEcommerce.JWT;

import com.FullFledgedEcommerce.repo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private User userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      com.FullFledgedEcommerce.entites.User userByEmail = userRepo.getUserByEmail(username);
       if(userByEmail!=null){
           return org.springframework.security.core.userdetails.User.builder()
                   .username(userByEmail.getEmail())
                   .password(userByEmail.getPassword())
//                   .roles(userByEmail.getRoles().toArray(String[]::new))
                   .build();
       }
        throw new UsernameNotFoundException("NOT FOUND");
    }
}
