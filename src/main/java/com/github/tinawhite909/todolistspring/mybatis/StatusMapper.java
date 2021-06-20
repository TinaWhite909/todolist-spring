package com.github.tinawhite909.todolistspring.mybatis;

import com.github.tinawhite909.todolistspring.bean.DBStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StatusMapper {
    @Select("SELECT \n" +
            "  t.\"ID\" id, \n" +
            "  t.\"STATUS\" status \n" +
            "FROM statuses t")
    List<DBStatus> getStatuses();

    @Select("SELECT \n" +
            "  t.\"ID\" id, \n" +
            "  t.\"STATUS\" status \n" +
            "FROM statuses t WHERE t.id = #{id}")
    DBStatus getStatusById(Long id);

}
