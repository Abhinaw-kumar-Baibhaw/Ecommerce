package com.FullFledgedEcommerce.controller;

import com.FullFledgedEcommerce.entites.User;
import com.FullFledgedEcommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public User createUser(@RequestBody User user){
      return  userService.createUser(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getById/{id}")
    public Optional<User> getById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getByEmail/{email}")
    public User getByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user){
        userService.updateUser(id, user);
        return "";
    }
}