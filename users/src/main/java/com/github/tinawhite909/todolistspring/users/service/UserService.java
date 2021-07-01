package com.github.tinawhite909.todolistspring.users.service;

import com.github.tinawhite909.todolistspring.users.bean.DBUser;
import com.github.tinawhite909.todolistspring.users.bean.NewUser;
import com.github.tinawhite909.todolistspring.users.mybatis.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public NewUser addUser(NewUser user) {
        DBUser dbUser = new DBUser.Builder()
                .setId(user.getId())
                .setLogin(user.getLogin())
                .setPassword(user.getPassword())
                .build();
        userMapper.addUser(dbUser);

        return user;
    }

    @Override
    public NewUser getUserById(Long userId){
        DBUser dbUser = userMapper.getUserById(userId);
        NewUser user = new NewUser.Builder()
                .setId(dbUser.getId())
                .setLogin(dbUser.getLogin())
                .setPassword(dbUser.getLogin())
                .build();
        return user;
    }
}
