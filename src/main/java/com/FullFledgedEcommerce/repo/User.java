package com.FullFledgedEcommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User extends JpaRepository<com.FullFledgedEcommerce.entites.User,Long> {

    com.FullFledgedEcommerce.entites.User getUserByEmail(String email);
}
