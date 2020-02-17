package com.sha.postgresql.service;

import com.sha.postgresql.model.Role;
import com.sha.postgresql.model.User;

import java.util.List;

/**
 * @author sa
 * @date 2020-02-09
 * @time 19:06
 */
public interface IUserService
{
    User saveUser(User user);

    User changeRole(Role newRole, String username);

    User findByUsername(String username);

    List<User> findAllUsers();
}
