package com.todo_management.todo_management.repository;

import com.todo_management.todo_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    Boolean existsByEmail(String email);
    User findByUsernameOrEmail(String username,String email);
}
