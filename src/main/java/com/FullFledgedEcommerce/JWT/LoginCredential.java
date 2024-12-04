package com.FullFledgedEcommerce.JWT;

import com.FullFledgedEcommerce.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class LoginCredential {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private com.FullFledgedEcommerce.repo.User userRepo;

    @Autowired
    private JwtService jwtService;


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody User user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
        String email = user.getEmail();
        User user1 = userRepo.getUserByEmail(email);
        String role =  user1.getRole().name();
        String token = jwtService.generateToken(email, role);
        return ResponseEntity.ok(token);
    }
}
