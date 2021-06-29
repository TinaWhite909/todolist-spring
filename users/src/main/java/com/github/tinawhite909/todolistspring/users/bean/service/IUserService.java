package com.github.tinawhite909.todolistspring.users.bean.service;

import com.github.tinawhite909.todolistspring.users.bean.bean.DBUser;
import com.github.tinawhite909.todolistspring.users.bean.bean.User;

public interface IUserService {

    User addUser(User user);
    User getUserById(Long userId);
}
