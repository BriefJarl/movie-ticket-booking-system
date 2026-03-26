package com.bhumi.moviebooking.repository;

import com.bhumi.moviebooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}