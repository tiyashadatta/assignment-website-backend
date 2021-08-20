package com.exam.services;

import com.exam.entities.User;
import com.exam.entities.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    public User getUserByUsername(String username);
    public void deleteUser(Long userId);
    public User updateUser(User user);
}
