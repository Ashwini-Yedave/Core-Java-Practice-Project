package com.ashwini.expense_tracker_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ashwini.expense_tracker_backend.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}