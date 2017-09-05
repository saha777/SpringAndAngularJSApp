package com.agromarket.repository;

import com.agromarket.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAll();

    User findById(String id);

    User findByEmail(String email);
}