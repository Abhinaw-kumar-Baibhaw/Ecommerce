package com.FullFledgedEcommerce.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Notification extends JpaRepository<com.FullFledgedEcommerce.entites.Notification,Long> {
}
