package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.DTO;

import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Model.Role;

public class UserDataDTO {

    private Long id;

    private String username;

    private String password;

    private Role role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
