package com.FullFledgedEcommerce.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrder extends JpaRepository<com.FullFledgedEcommerce.entites.CustomerOrder,Long> {
}
