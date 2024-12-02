package com.FullFledgedEcommerce.service;

import com.FullFledgedEcommerce.entites.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User getUserByEmail(String email);

    void deleteUserById(Long id);

    String updateUser(Long id,User user);
}
