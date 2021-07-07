package com.github.tinawhite909.todolistspring.users.service;

import com.github.tinawhite909.todolistspring.users.bean.DBUser;
import com.github.tinawhite909.todolistspring.users.bean.NewUser;
import com.github.tinawhite909.todolistspring.users.mybatis.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public NewUser addUser(NewUser user) {
        DBUser dbUser = new DBUser.Builder()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setRoles("ROLE_USER")
                .build();
        userMapper.addUser(dbUser);

        return user;
    }

//    @Override //&&&
//    public NewUser getUserByName(String username){
//        DBUser dbUser = userMapper.getUserByName(username);
//        NewUser user = new NewUser.Builder()
//                .setId(dbUser.getId())
//                .setLogin(dbUser.getUsername())
//                .setPassword(dbUser.getUsername())
//                .setRoles(dbUser.getRoles())
//                .build();
//        return user;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DBUser dbUser = userMapper.getUserByName(username);
        if(dbUser==null){
            throw new UsernameNotFoundException("Unknown user: "+username);
        }
        UserDetails user = User.builder()
                .username(dbUser.getUsername())
                .password(dbUser.getUsername())
                .roles(dbUser.getRoles())
                .build();
        return user;
    }
}
