package com.usergroupservice.dao;

import com.usergroupservice.entities.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupDao extends JpaRepository<UserGroup,Long> {
}
