package com.greatlearning.graded.project.employee.management.repository;

import com.greatlearning.graded.project.employee.management.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
