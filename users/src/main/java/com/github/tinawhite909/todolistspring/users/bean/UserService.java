package com.github.tinawhite909.todolistspring.users.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired(required = false)
    private  UserMapper userMapper;


    @Override
    public User addUser(User user) {
        DBUser dbUser = new DBUser.Builder()
                .setId(user.getId())
                .setLogin(user.getLogin())
                .setPassword(user.getPassword())
                .build();
        userMapper.addUser(dbUser);

        return user;
    }
}
