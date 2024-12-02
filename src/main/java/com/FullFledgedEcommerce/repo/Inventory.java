package com.FullFledgedEcommerce.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Inventory extends JpaRepository<com.FullFledgedEcommerce.entites.Inventory,Long> {
}
