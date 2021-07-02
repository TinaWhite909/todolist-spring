package com.github.tinawhite909.todolistspring.users.mybatis;

import com.github.tinawhite909.todolistspring.users.bean.DBUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO public.users(\n" +
            "\"USERNAME\", \"PASSWORD\")" +
            " \t VALUES (#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "USER_ID")
    Integer addUser(DBUser dbUser);

    @Select("SELECT t.\"USER_ID\", " +
            "       t.\"USERNAME\", " +
            "       t.\"PASSWORD\" " +
            "FROM public.users t " +
            "WHERE T.USERNAME = #{username}")
    DBUser getUserByName(String username);
}
