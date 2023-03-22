package com.osorio.supermarket.repository;

import com.osorio.supermarket.entity.Product;
import com.osorio.supermarket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
