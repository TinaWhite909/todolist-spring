package com.github.tinawhite909.todolistspring.users.mybatis;

import com.github.tinawhite909.todolistspring.users.bean.DBUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO public.users(\n" +
            "\"USERNAME\", \"PASSWORD\" )" +
            " \t VALUES (#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID")
    Integer addUser(DBUser dbUser);

    @Insert("INSERT INTO role_users VALUES(\n" +
            "(SELECT ID from  users where username = #{username}),\n" +
            "(SELECT ID from  roles where role = #{role})\n" +
            ")")
    Integer addRole(String username, String role);

    @Select("select u.username, u.password " +
            "from users u " +
            "where username = #{username}")
    DBUser getUserByName(String username);

    @Select("select r.role from users u " +
            "LEFT JOIN role_users sru on u.id= sru.id " +
            "LEFT JOIN roles r on sru.role=r.id " +
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
        LEFT JOIN roles r on sru.role=r.id
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

    /*
    INSERT INTO role_users VALUES (
(SELECT ID from  users where username='ee'),
(SELECT ID from  roles where role='ROLE_USER')
)
     */

}
