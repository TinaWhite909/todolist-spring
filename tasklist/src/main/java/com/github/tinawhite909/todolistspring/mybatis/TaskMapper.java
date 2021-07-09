package com.github.tinawhite909.todolistspring.mybatis;

import com.github.tinawhite909.todolistspring.bean.DBStatus;
import com.github.tinawhite909.todolistspring.bean.DBTask;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Select(" SELECT TASK_ID ID,\n" +
            "START_DATE startDate,\n" +
            "FINISH_DATE finishDate,\n" +
            "TASK content,\n" +
            "STATUS_ID status_id,\n" +
            "ASSIGNER assigner,\n" +
            "ASSIGNED_TO assigned_to\n" +
            "FROM tasklist")
    @Results(value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "startDate", column = "startDate"),
            @Result(property = "finishDate", column = "finishDate"),
            @Result(property = "content", column = "content"),
            @Result(property = "status", column = "status_id", one = @One(select = "getStatusById")),
            @Result(property = "assigner", column = "assigner"),
            @Result(property = "assigned_to", column = "assigned_to")
    })
    List<DBTask> getTasks();

    @Select("SELECT \n" +
            "  t.\"ID\" id, \n" +
            "  t.\"STATUS\" status \n" +
            "FROM statuses t WHERE t.id = #{status_id}")
    DBStatus getStatusById(Long status_id);


    @Insert("INSERT INTO public.tasklist(\n" +
            "\"START_DATE\", \"FINISH_DATE\", \"TASK\", \"STATUS_ID\", \"ASSIGNER\", \"ASSIGNED_TO\")\n" +
            "\tVALUES (#{startDate}, #{finishDate}, #{content}, #{status.id}, #{assigner}, #{assigned_to});")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "TASK_ID")
    Integer addTask(DBTask task);

    @Select(" SELECT TASK_ID ID,\n" +
            "START_DATE startDate,\n" +
            "FINISH_DATE finishDate,\n" +
            "TASK content,\n" +
            "STATUS_ID status_id,\n" +
            "ASSIGNER assigner,\n" +
            "ASSIGNED_TO assigned_to\n" +
            "FROM tasklist " +
            "WHERE TASK_ID = #{taskId}")
    @Results(value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "startDate", column = "startDate"),
            @Result(property = "finishDate", column = "finishDate"),
            @Result(property = "content", column = "content"),
            @Result(property = "status", column = "status_id", one = @One(select = "getStatusById")),
            @Result(property = "assigner", column = "assigner"),
            @Result(property = "assigned_to", column = "assigned_to")
    })
    DBTask getTaskById(Long taskId);

    @Update("UPDATE public.tasklist t " +
            "SET t.status_id = #{statusId} " +
            "WHERE t.task_id = #{taskId}")
    void updateStatus(Long taskId, Long statusId);

    /*
    SELECT TASK_ID ID,
START_DATE startDate,
FINISH_DATE finishDate,
TASK content,
STATUS_ID status_id,
ASSIGNER assigner,
ASSIGNED_TO assigned_to
FROM tasklist
     */
}


