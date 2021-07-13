package com.github.tinawhite909.todolistspring.users.service;

import com.github.tinawhite909.todolistspring.users.bean.NewUser;
import com.github.tinawhite909.todolistspring.users.bean.SysRole;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

public interface IUserService {

    NewUser addUser(NewUser newUser);
    String getRoleByUsername(String username) throws RoleNotFoundException;
    List<NewUser> getUsers();
//    NewUser getUserByName(String username);
}
