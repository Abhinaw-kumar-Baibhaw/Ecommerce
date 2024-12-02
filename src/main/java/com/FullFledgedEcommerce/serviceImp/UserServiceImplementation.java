package com.FullFledgedEcommerce.serviceImp;

import com.FullFledgedEcommerce.entites.User;
import com.FullFledgedEcommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private com.FullFledgedEcommerce.repo.User userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
       return userRepo.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return  userRepo.findById(id);
    }

    @Override
    public User getUserByEmail(String email) {
      return userRepo.getUserByEmail(email);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public String updateUser(Long id, User user) {
        Optional<User> byId = userRepo.findById(id);
        if(byId.isPresent()){
            User user1 = byId.get();
            user1.setEmail(user.getEmail());
            user1.setPhone(user.getPhone());
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setPassword(user.getPassword());
            userRepo.save(user1);
        }
        return "updated";
    }
}
