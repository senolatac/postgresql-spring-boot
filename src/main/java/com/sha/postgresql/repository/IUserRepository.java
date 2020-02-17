package com.sha.postgresql.repository;

import com.sha.postgresql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author sa
 * @date 2020-02-09
 * @time 15:08
 */
public interface IUserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByUsername(String username);
}
