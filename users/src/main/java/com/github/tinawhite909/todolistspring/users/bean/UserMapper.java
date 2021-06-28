package com.github.tinawhite909.todolistspring.users.bean;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO public.users(\n" +
            "\"LOGIN\", \"PASSWORD\"\n" +
            "\tVALUES (#{login}, #{password};")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "USER_ID")
    Integer addUser(DBUser user);
}
