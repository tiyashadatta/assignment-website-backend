package com.userservice.services;

import com.userservice.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface UserService {

    public User addUser(User user);
    public User updateUser(User user);
    public void deleteUser(Long userId);
    public Set<User> viewUsers();
    public User viewSingleUser(Long userId);
    public List<User> getUsersOfUserGroups(Long userGroupId);
}
