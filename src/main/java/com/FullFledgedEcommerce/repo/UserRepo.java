package com.FullFledgedEcommerce.repo;

import com.FullFledgedEcommerce.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    User getUserByEmail(String email);
}
