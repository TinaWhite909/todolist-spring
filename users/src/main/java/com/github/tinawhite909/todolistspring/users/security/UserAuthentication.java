package com.github.tinawhite909.todolistspring.users.security;

import com.github.tinawhite909.todolistspring.users.bean.DBUser;
import com.github.tinawhite909.todolistspring.users.mybatis.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserAuthentication implements AuthenticationProvider {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getPrincipal().toString();

        DBUser user = userMapper.getUserByName(username);
        if (user==null) {
            throw  new BadCredentialsException("Unknown user "+ username);
        }
        if (!password.equals(user.getPassword())){
            throw new BadCredentialsException("Wrong password");
        }

        UserDetails principal = User.builder()
                .username(user.getUsername())
                .password(user.getUsername())
                .roles(user.getRoles())
                .build();
        return new UsernamePasswordAuthenticationToken(principal, password, principal.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
