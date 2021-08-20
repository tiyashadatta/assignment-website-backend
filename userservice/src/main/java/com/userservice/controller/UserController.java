package com.userservice.controller;

import com.userservice.dao.UserDao;
import com.userservice.entities.User;
import com.userservice.entities.UserGroup;
import com.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
//@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody User user){
        User user1 =this.userService.addUser(user);
        return ResponseEntity.ok(user1);
    }

    @PutMapping("/")
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }

    @GetMapping("/")
    public Set<User> viewUsers(){
        return this.userService.viewUsers();
    }

    @GetMapping("/{userId}")
    public User viewSingleUser(@PathVariable Long userId){
        return this.userService.viewSingleUser(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        this.userService.deleteUser(userId);
    }

    @GetMapping("/usergroup/{userGroupId}")
    public List<User> getUsersOfUserGroups(@PathVariable Long userGroupId) {
        return this.userService.getUsersOfUserGroups(userGroupId);
    }
}
