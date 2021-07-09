package com.github.tinawhite909.todolistspring.users.service;

import com.github.tinawhite909.todolistspring.users.bean.DBUser;
import com.github.tinawhite909.todolistspring.users.bean.NewUser;
import com.github.tinawhite909.todolistspring.users.mybatis.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public NewUser addUser(NewUser user) {
        String role = "ROLE_USER";
        DBUser dbUser = new DBUser.Builder()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setRoles(role)
                .build();
        userMapper.addUser(dbUser);
        userMapper.addRole(user.getUsername(), role);
        return user;
    }

    @Override
    public List<NewUser> getUsernames() {
        List<NewUser> newUsers = new ArrayList<>();
        List<DBUser> dbUsers = userMapper.getUsernames();
        for (DBUser dbUser : dbUsers) {

            NewUser user = new NewUser.Builder()
                    .setUsername(dbUser.getUsername())
                    .build();
            newUsers.add(user);
        }
        return newUsers;
    }

//    @Override
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
    public String getRoleByUsername(String username) {
        String role = userMapper.getRoleByUsername(username);
        return role;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DBUser dbUser = userMapper.getUserByName(username);
        if (dbUser == null) {
            throw new UsernameNotFoundException("Unknown user: " + username);
        }
        String role = getRoleByUsername(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            if (role != null) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
                grantedAuthorities.add(grantedAuthority);
            }
        UserDetails user = User.builder()
                .username(dbUser.getUsername())
                .password(dbUser.getPassword())
                .authorities(grantedAuthorities)
                .build();
        System.out.println(user.getPassword());
        System.out.println(user.getAuthorities());
        return user;
    }
}
