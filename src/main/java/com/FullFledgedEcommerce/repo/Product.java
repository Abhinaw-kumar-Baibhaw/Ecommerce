package com.FullFledgedEcommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product extends JpaRepository<com.FullFledgedEcommerce.entites.Product,Long> {
}
