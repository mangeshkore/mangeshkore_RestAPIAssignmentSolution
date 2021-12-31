package com.greatlearning.graded.project.employee.management.service;

import com.greatlearning.graded.project.employee.management.entities.Employee;

import java.util.List;

public interface EmployeeManagementService {

    List<Employee> findAllEmployees();

    Employee findEmployeeByID(int id);

    void deleteEmployee(int id);

    Employee saveEmployee(Employee newEmployee);

    List<Employee> getEmployeeByFirstName(String firstName);

    List<Employee> getEmployeesInOrder(String order);
}
