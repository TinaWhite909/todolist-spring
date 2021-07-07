package com.github.tinawhite909.todolistspring.users.mybatis;

import com.github.tinawhite909.todolistspring.users.bean.DBUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO public.users(\n" +
            "\"USERNAME\", \"PASSWORD\" )" +
            " \t VALUES (#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "USER_ID")
    Integer addUser(DBUser dbUser);



    @Select("select u.username, u.password, r.name " +
            "from users u " +
            "LEFT JOIN role_users sru on u.user_id= sru.id " +
            "LEFT JOIN roles r on sru.id=r.role_id " +
            "where username = #{username}")
    DBUser getUserByName(String username);

}
