package com.greatlearning.graded.project.employee.management.service;

import com.greatlearning.graded.project.employee.management.entities.Role;
import com.greatlearning.graded.project.employee.management.entities.User;
import com.greatlearning.graded.project.employee.management.repository.RoleRepository;
import com.greatlearning.graded.project.employee.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl implements UserManagementService{

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
