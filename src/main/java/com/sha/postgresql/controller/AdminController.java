package com.sha.postgresql.controller;

import com.sha.postgresql.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author sa
 * @date 2020-02-15
 * @time 13:32
 */
@RestController
//api/admin/**
@RequestMapping("api/admin")
public class AdminController
{
    @Autowired
    private IUserService userService;

    // GET api/admin/all
    // reachable by just ADMIN
    @GetMapping("all")
    public ResponseEntity<?> getAllUsers(
            // Admin role should be but parameter doesnt used so we can remove it.
            // Principal principal
    )
    {
        return ResponseEntity.ok(userService.findAllUsers());
    }
}
