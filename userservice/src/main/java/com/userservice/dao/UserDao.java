package com.userservice.dao;

import com.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {

//    @Query("select u from User u where u.user_group_id = :userGroupId")
//    List<User> fetchByUserGroupId(@Param("userGroupId") Long userGroupId);

    public List<User> findByUserGroupId(Long userGroupId);
}
