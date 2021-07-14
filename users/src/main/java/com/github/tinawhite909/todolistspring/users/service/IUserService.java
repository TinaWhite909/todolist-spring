package com.github.tinawhite909.todolistspring.users.service;

import com.github.tinawhite909.todolistspring.users.bean.NewUser;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

public interface IUserService {

    NewUser addUser(NewUser newUser);

    String getRoleByUsername(String username) throws RoleNotFoundException;

    List<NewUser> getUsers();
}
