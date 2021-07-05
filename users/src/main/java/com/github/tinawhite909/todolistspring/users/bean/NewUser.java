package com.github.tinawhite909.todolistspring.users.bean;

import java.util.List;

public class NewUser {
    private Long id;
    private String username;
    private String password;
    private List<SysRole> roles;

    public NewUser(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.roles = builder.roles;
    }

    public NewUser() {
    }

    public NewUser(Long id, String username, String password, List<SysRole> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public static class Builder {
        Long id;
        String username;
        String password;
        List<SysRole> roles;

        public Builder setId(Long iD) {
            id = iD;
            return this;
        }

        public Builder setLogin(String log) {
            username = log;
            return this;
        }

        public Builder setPassword(String pas) {
            password = pas;
            return this;
        }

        public Builder setRoles(List<SysRole> roles1) {
            roles = roles1;
            return this;
        }

        public NewUser build() {
            return new NewUser(this);
        }
    }
}
