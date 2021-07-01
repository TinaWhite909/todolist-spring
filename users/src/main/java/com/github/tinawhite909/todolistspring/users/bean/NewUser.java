package com.github.tinawhite909.todolistspring.users.bean;

public class NewUser {
    private Long id;
    private String login;
    private String password;

    public NewUser(Builder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
    }

    public NewUser() {
    }

    public NewUser(Long id, String login, String password) {
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

        public NewUser build() {
            return new NewUser(this);
        }
    }
}
