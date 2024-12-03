package com.FullFledgedEcommerce.serviceImp;

import com.FullFledgedEcommerce.entites.CustomerOrder;
import com.FullFledgedEcommerce.entites.Product;
import com.FullFledgedEcommerce.entites.User;
import com.FullFledgedEcommerce.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService {

    @Override
    public CustomerOrder createOrder(User user, List<Product> products) {
        return null;
    }

    @Override
    public CustomerOrder addProductToOrder(Long orderId, Product product, int quantity) {
        return null;
    }
}
