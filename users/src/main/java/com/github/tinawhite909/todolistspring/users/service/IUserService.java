package com.github.tinawhite909.todolistspring.users.service;

import com.github.tinawhite909.todolistspring.users.bean.NewUser;

public interface IUserService {

    NewUser addUser(NewUser newUser);
    NewUser getUserByName(String username);
}
