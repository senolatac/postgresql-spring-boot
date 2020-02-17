package com.sha.postgresql.service;

import com.sha.postgresql.model.Role;
import com.sha.postgresql.model.User;
import com.sha.postgresql.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sa
 * @date 2020-02-09
 * @time 19:06
 */
@Service
public class UserService implements IUserService
{
    @Autowired
    private IUserRepository userRepository;

    //We should describe it as bean.
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user)
    {
        //also store password as encrypted.
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateDate(LocalDateTime.now());
        //default role is USER.
        user.setRole(Role.ROLE_USER);
        return userRepository.save(user);
    }

    @Override
    public User changeRole(Role newRole, String username)
    {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException());
        user.setRole(newRole);
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<User> findAllUsers()
    {
        return userRepository.findAll();
    }
}
