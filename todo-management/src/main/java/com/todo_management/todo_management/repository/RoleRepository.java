package com.todo_management.todo_management.repository;

import com.todo_management.todo_management.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
