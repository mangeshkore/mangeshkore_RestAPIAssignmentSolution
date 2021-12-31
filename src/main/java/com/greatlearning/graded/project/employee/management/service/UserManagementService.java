package com.greatlearning.graded.project.employee.management.service;

import com.greatlearning.graded.project.employee.management.entities.Role;
import com.greatlearning.graded.project.employee.management.entities.User;

public interface UserManagementService {
    Role saveRole(Role role);

    User saveUser(User user);
}
