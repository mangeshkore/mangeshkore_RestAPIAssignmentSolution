package com.greatlearning.graded.project.employee.management.repository;

import com.greatlearning.graded.project.employee.management.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsername(String username);
}