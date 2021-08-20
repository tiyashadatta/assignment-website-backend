package com.usergroupservice.services;

import com.usergroupservice.dao.UserGroupDao;
import com.usergroupservice.entities.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserGroupServiceImpl implements UserGroupService {

    @Autowired
    private UserGroupDao userGroupDao;

    @Override
    public UserGroup addUserGroup(UserGroup userGroup) {
        return this.userGroupDao.save(userGroup);
    }

    @Override
    public UserGroup updateUserGroup(UserGroup userGroup) {
        return this.userGroupDao.save(userGroup);
    }

    @Override
    public void deleteUserGroup(Long userGroupId) {
        UserGroup userGroup = new UserGroup();
        userGroup.setGroupId(userGroupId);
        this.userGroupDao.delete(userGroup);
    }

    @Override
    public Set<UserGroup> viewUserGroups() {
        return new HashSet<>(this.userGroupDao.findAll());
    }

    @Override
    public UserGroup viewSingleUserGroup(Long userGroupId) {
        return this.userGroupDao.findById(userGroupId).get();
    }
}
