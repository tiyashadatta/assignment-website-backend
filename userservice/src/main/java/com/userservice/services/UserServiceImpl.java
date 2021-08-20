package com.userservice.services;

import com.userservice.dao.UserDao;
import com.userservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user) {
        return this.userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        return this.userDao.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userDao.deleteById(userId);
    }

    @Override
    public Set<User> viewUsers() {
        return new HashSet<>(this.userDao.findAll());
    }

    @Override
    public User viewSingleUser(Long userId) {
        return this.userDao.findById(userId).get();
    }

    @Override
    public List<User> getUsersOfUserGroups(Long userGroupId) {
        return this.userDao.findByUserGroupId(userGroupId);
    }

}
