package com.lacite.programmationDistribuee.repository;

import com.lacite.programmationDistribuee.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByUsername(String username);


}