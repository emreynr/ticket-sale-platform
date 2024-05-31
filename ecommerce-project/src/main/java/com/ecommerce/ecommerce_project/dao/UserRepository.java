package com.ecommerce.ecommerce_project.dao;

import com.ecommerce.ecommerce_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
