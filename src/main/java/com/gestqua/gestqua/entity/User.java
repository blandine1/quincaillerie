package com.gestqua.gestqua.entity;

import jakarta.persistence.*;
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String secoundname;
    private String email;
    private String password;
    private Role role;
}
