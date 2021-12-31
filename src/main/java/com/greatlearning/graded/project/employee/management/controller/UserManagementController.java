package com.greatlearning.graded.project.employee.management.controller;

import com.greatlearning.graded.project.employee.management.entities.Role;
import com.greatlearning.graded.project.employee.management.entities.User;
import com.greatlearning.graded.project.employee.management.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping("/role")
    public Role addRole(@RequestBody Role role) {
        return userManagementService.saveRole(role);
    }

    @PostMapping("/user")
    public User addRole(@RequestBody User user) {
        return userManagementService.saveUser(user);
    }
}
