package com.FullFledgedEcommerce.serviceImp;

import com.FullFledgedEcommerce.entites.CustomerOrder;
import com.FullFledgedEcommerce.entites.Product;
import com.FullFledgedEcommerce.entites.User;
import com.FullFledgedEcommerce.repo.UserRepo;
import com.FullFledgedEcommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private UserRepo userRepo;


    @Override
    public User createUser(User user) {
        String password = user.getPassword();
        String encode = new BCryptPasswordEncoder().encode(password);
        user.setPassword(encode);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
       return userRepo.findAll();
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

    public Optional<User> getUserById(Long id) {
        Optional<User> byId = userRepo.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            try {
                String url = "http://FullFledgedOrder/orders/getUserOrders/" + user.getId();
                CustomerOrder[] customerOrdersArray = restTemplate.getForObject(url, CustomerOrder[].class);
                List<CustomerOrder> customerOrders = Arrays.asList(customerOrdersArray);
                user.setCustomerOrder(customerOrders);
                String url2 = "http://FullFledgedProductPart/products/getUserProducts/" + user.getId();
                Product[] products = restTemplate.getForObject(url2,Product[].class);
                List<Product> productsList = Arrays.asList(products);
                user.setProducts(productsList);
                return Optional.of(user);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return Optional.empty();
    }
}
