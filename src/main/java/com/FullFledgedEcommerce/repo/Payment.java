package com.FullFledgedEcommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Payment extends JpaRepository<com.FullFledgedEcommerce.entites.Payment,Long> {
}
