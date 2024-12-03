package com.FullFledgedEcommerce.JWT;

import com.FullFledgedEcommerce.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/auth")
public class LoginCredential {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private com.FullFledgedEcommerce.repo.User userRepo;

    @Autowired
    private JwtService jwtService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody User user){
        String email = user.getEmail();
        String password = user.getPassword();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Optional<User> user1 = Optional.ofNullable(userRepo.getUserByEmail(email));
        if (user1.isPresent()){
            String token = jwtService.generateToken(email,authorities);
            return ResponseEntity.ok(token);
        }
        else {
            return new ResponseEntity<>("message", HttpStatus.NOT_FOUND);
        }
    }
}
