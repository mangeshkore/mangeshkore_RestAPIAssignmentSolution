package com.greatlearning.graded.project.employee.management.controller;

import com.greatlearning.graded.project.employee.management.entities.Employee;
import com.greatlearning.graded.project.employee.management.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeManagementController {
    @Autowired
    private EmployeeManagementService employeeManagementService;

    @GetMapping("/list")
    public List<Employee> listEmployees() {
        List<Employee> employees = employeeManagementService.findAllEmployees();
        return employees;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeDetails(@PathVariable("id") int id) {
        return employeeManagementService.findEmployeeByID(id);
    }


    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee) {
        Employee employeeObj;
        if (employee.getId() != 0) {
            employeeObj = employeeManagementService.findEmployeeByID(employee.getId());
            employeeObj.setFirstName(employee.getFirstName());
            employeeObj.setLastName(employee.getLastName());
            employeeObj.setEmail(employee.getEmail());
        } else {
            employeeObj = new Employee(employee.getFirstName(), employee.getLastName(), employee.getEmail());
        }
        return employeeManagementService.saveEmployee(employeeObj);

    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeManagementService.deleteEmployee(id);
        return "Deleted employee id - " + id;
    }

    @GetMapping("/search/{firstName}")
    public List<Employee> getEmployeeByName(@PathVariable("firstName") String firstName) {
        return employeeManagementService.getEmployeeByFirstName(firstName);
    }

    @GetMapping("/sort")
    public List<Employee> getEmployeeInOrder(@RequestParam("order") String order) {
        return employeeManagementService.getEmployeesInOrder(order);
    }

    @RequestMapping(value = "/403")
    public String accessDenied(Principal user) {
        return "Access Denied...Sorry, you do not have permission to view this page.";
    }
}
