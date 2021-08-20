package com.usergroupservice.controller;

import com.usergroupservice.dao.UserGroupDao;
import com.usergroupservice.entities.UserGroup;
import com.usergroupservice.services.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@RestController
@RequestMapping("/usergroup")
//@CrossOrigin("*")
public class UserGroupController {

    @Autowired
    private UserGroupDao userGroupDao;

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/")
    public ResponseEntity<?> addUserGroup(@RequestBody UserGroup userGroup){
        UserGroup userGroup1 = this.userGroupService.addUserGroup(userGroup);
        return ResponseEntity.ok(userGroup1);
    }

    @GetMapping("/")
    public Set<UserGroup> getUserGroups(){
        return this.userGroupService.viewUserGroups();
    }

    @GetMapping("/{userGroupId}")
    public UserGroup getSingleUserGroup(@PathVariable Long userGroupId){
        UserGroup userGroup = this.userGroupService.viewSingleUserGroup(userGroupId);
        Set users = this.restTemplate.getForObject("http://webadmin-user/user/usergroup/" + userGroupId,Set.class);
        userGroup.setUsers(users);
        return userGroup;
    }

    @PutMapping("/")
    public UserGroup updateUserGroup(@RequestBody UserGroup userGroup){
        return this.userGroupService.updateUserGroup(userGroup);
    }

    @DeleteMapping("/{userGroupId}")
    public void deleteUserGroup(@PathVariable Long userGroupId){
        this.userGroupService.deleteUserGroup(userGroupId);
    }

}
