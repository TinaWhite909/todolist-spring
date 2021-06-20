package com.github.tinawhite909.todolistspring.mybatis;

import com.github.tinawhite909.todolistspring.bean.DBTask;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Select("SELECT \n" +
            "  t.\"TASK_ID\" ID, \n" +
            "  t.\"START_DATE\" startDate, \n" +
            "  t.\"FINISH_DATE\" finishDate, \n" +
            "  t.\"TASK\" \"content\"\n" +

            "FROM public.tasklist t")
    List<DBTask> getTasks();

    @Insert("INSERT INTO public.tasklist(\n" +
            "\"START_DATE\", \"FINISH_DATE\", \"TASK\")\n" +
            "\tVALUES (#{startDate}, #{finishDate}, #{content});")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "TASK_ID")
    Integer addTask(DBTask task);
}


