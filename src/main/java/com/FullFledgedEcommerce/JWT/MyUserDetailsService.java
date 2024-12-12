package com.FullFledgedEcommerce.JWT;

import com.FullFledgedEcommerce.entites.ForUserDetails;
import com.FullFledgedEcommerce.entites.User;
import com.FullFledgedEcommerce.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User userByEmail = userRepo.getUserByEmail(username);
      return new ForUserDetails(userByEmail);
    }
}
