package com.sha.postgresql.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author sa
 * @date 2020-02-09
 * @time 12:52
 */
@Data
@Entity
@Table(name = "users") // the name user can be ambiguous for postgresql main tables.
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    //getters, setters will be handled by lombok.
}
