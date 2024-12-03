package com.FullFledgedEcommerce.service;

import com.FullFledgedEcommerce.entites.CustomerOrder;
import com.FullFledgedEcommerce.entites.Product;
import com.FullFledgedEcommerce.entites.User;
import java.util.List;


public interface OrderService {

    public CustomerOrder createOrder(User user, List<Product> products) ;

    public CustomerOrder  addProductToOrder(Long orderId, Product product, int quantity);

}
