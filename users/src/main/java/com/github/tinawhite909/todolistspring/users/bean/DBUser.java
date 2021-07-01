package com.github.tinawhite909.todolistspring.users.bean;

public class DBUser {
    private Long id;
    private String login;
    private String password;

    public DBUser(Builder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
    }

    public DBUser() {
    }

    public DBUser(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class Builder {
        Long id;
        String login;
        String password;


        public Builder setId(Long iD) {
            id = iD;
            return this;
        }

        public Builder setLogin(String log) {
            login = log;
            return this;
        }

        public Builder setPassword(String pas) {
            password = pas;
            return this;
        }

        public DBUser build() {
            return new DBUser(this);
        }
    }

}
