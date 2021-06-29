package com.github.tinawhite909.todolistspring.users.bean.service;

import com.github.tinawhite909.todolistspring.users.bean.bean.User;
import com.github.tinawhite909.todolistspring.users.bean.mybatis.UserMapper;
import com.github.tinawhite909.todolistspring.users.bean.bean.DBUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;


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

    @Override
    public User getUserById(Long userId){
        DBUser dbUser = userMapper.getUserById(userId);
        User user = new User.Builder()
                .setId(dbUser.getId())
                .setLogin(dbUser.getLogin())
                .setPassword(dbUser.getLogin())
                .build();
        return user;
    }
}
