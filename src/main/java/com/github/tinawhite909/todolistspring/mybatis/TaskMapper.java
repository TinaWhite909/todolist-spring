package com.github.tinawhite909.todolistspring.mybatis;

import com.github.tinawhite909.todolistspring.bean.DBStatus;
import com.github.tinawhite909.todolistspring.bean.DBTask;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Select("SELECT \n" +
            "  t.\"TASK_ID\" ID, \n" +
            "  t.\"START_DATE\" startDate, \n" +
            "  t.\"FINISH_DATE\" finishDate, \n" +
            "  t.\"TASK\" \"content\", \n" +
            "  t.\"STATUS_ID\" \"status_id\"  \n" +
            "FROM public.tasklist t ")
    @Results(value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "startDate", column = "startDate"),
            @Result(property = "finishDate", column = "finishDate"),
            @Result(property = "content", column = "content"),
            @Result(property = "status", column = "status_id", one = @One(select = "getStatusById"))
    })
    List<DBTask> getTasks();

    @Select("SELECT \n" +
            "  t.\"ID\" id, \n" +
            "  t.\"STATUS\" status \n" +
            "FROM statuses t WHERE t.id = #{status_id}")
    DBStatus getStatusById(Long status_id);


    @Insert("INSERT INTO public.tasklist(\n" +
            "\"START_DATE\", \"FINISH_DATE\", \"TASK\", \"STATUS_ID\")\n" +
            "\tVALUES (#{startDate}, #{finishDate}, #{content}, #{status.id});")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "TASK_ID")
    Integer addTask(DBTask task);

    @Select("SELECT \n" +
            "  t.\"TASK_ID\" ID, \n" +
            "  t.\"START_DATE\" startDate, \n" +
            "  t.\"FINISH_DATE\" finishDate, \n" +
            "  t.\"TASK\" \"content\", \n" +
            "  t.\"STATUS_ID\" \"status_id\"  \n" +
            "FROM public.tasklist t " +
            "WHERE T.TASK_ID = #{taskId}")
    @Results(value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "startDate", column = "startDate"),
            @Result(property = "finishDate", column = "finishDate"),
            @Result(property = "content", column = "content"),
            @Result(property = "status", column = "status_id", one = @One(select = "getStatusById"))
    })
    DBTask getTaskById(Long taskId);

    @Update("UPDATE public.tasklist t " +
            "SET t.status_id = #{statusId} " +
            "WHERE t.task_id = #{taskId}")
    void updateStatus(Long taskId, Long statusId);

}


