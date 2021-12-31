package com.greatlearning.graded.project.employee.management.repository;

import com.greatlearning.graded.project.employee.management.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstName(String firstName);

    List<Employee> findAllByOrderByFirstNameDesc();

    List<Employee> findAllByOrderByFirstNameAsc();
}
