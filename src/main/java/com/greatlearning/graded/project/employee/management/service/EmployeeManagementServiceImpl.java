package com.greatlearning.graded.project.employee.management.service;

import com.greatlearning.graded.project.employee.management.entities.Employee;
import com.greatlearning.graded.project.employee.management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeByID(int id) {
        return employeeRepository.getById(id);
    }

    @Override
    public Employee saveEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @Override
    public List<Employee> getEmployeeByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    @Override
    public List<Employee> getEmployeesInOrder(String order) {
        if (order.equalsIgnoreCase("desc"))
            return employeeRepository.findAllByOrderByFirstNameDesc();
        else if (order.equalsIgnoreCase("asc"))
            return employeeRepository.findAllByOrderByFirstNameAsc();
        else
            return findAllEmployees();
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}