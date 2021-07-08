package com.github.tinawhite909.todolistspring.users.mybatis;

import com.github.tinawhite909.todolistspring.users.bean.DBUser;
import com.github.tinawhite909.todolistspring.users.bean.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO public.users(\n" +
            "\"USERNAME\", \"PASSWORD\" )" +
            " \t VALUES (#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID")
    Integer addUser(DBUser dbUser);


    @Select("select u.username, u.password " +
            "from users u " +
            "where username = #{username}")
    DBUser getUserByName(String username);

    @Select("select r.role from users u " +
            "LEFT JOIN role_users sru on u.id= sru.id " +
            "LEFT JOIN roles r on sru.id=r.id " +
            "where u.username = #{username}")
    String getRoleByUsername(String username);

    @Select("SELECT t.id,  t.username FROM users t ")
    List<DBUser> getUsernames();

    /*
select u.username, u.password, r.role from users u
LEFT JOIN role_users sru on u.id= sru.id
LEFT JOIN roles r on sru.id=r.id
where username = 'qq'
*/

/*
Role
select r.role
        from users u
        LEFT JOIN role_users sru on u.id= sru.id
        LEFT JOIN roles r on sru.id=r.id
        where u.id=1
 */

/*
Permissions
select p.*
        from users u
        LEFT JOIN role_users sru on u.id= sru.id
        LEFT JOIN roles r on sru.id=r.id
        LEFT JOIN permission_role spr on spr.roles_id=r.id
        LEFT JOIN permissions p on p.id =spr.permission_id
        where u.id=1
 */

}
