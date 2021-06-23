package com.github.tinawhite909.todolistspring.service;

import com.github.tinawhite909.todolistspring.bean.DBStatus;
import com.github.tinawhite909.todolistspring.bean.DBTask;
import com.github.tinawhite909.todolistspring.bean.NewTask;
import com.github.tinawhite909.todolistspring.exception.TaskServiceRuntimeException;
import com.github.tinawhite909.todolistspring.mybatis.StatusMapper;
import com.github.tinawhite909.todolistspring.mybatis.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private StatusMapper statusMapper;

    @Override
    public List<NewTask> getTasks() {
        List<NewTask> newTasks = new ArrayList<>();
        List<DBTask> dbTasks = taskMapper.getTasks();
        for (DBTask dbTask : dbTasks) {

            NewTask task = new NewTask.Builder()
                    .setId(dbTask.getId())
                    .setStartDate(dbTask.getStartDate())
                    .setFinishDate(dbTask.getFinishDate())
                    .setContent(dbTask.getContent())
                    .build();

            if (dbTask.getStatus() == null) {
                task.setStatus("");
            } else {
                task.setStatus(dbTask.getStatus().getStatus());
            }


            newTasks.add(task);
        }
        return newTasks;
    }

    @Override
    public NewTask addTask(NewTask newTask) {

        if (newTask.getFinishDate() == null || LocalDate.now().isAfter(newTask.getFinishDate())) {
            throw new TaskServiceRuntimeException("FinishDate is null or in the past!");
        }
        if (!StringUtils.hasText(newTask.getContent())) {
            throw new TaskServiceRuntimeException("Task content is null!");
        }

        DBTask task = new DBTask.Builder()
                .setId(newTask.getId())
                .setStartDate(LocalDate.now())
                .setFinishDate(newTask.getFinishDate())
                .setContent(newTask.getContent())
                .setStatus(new DBStatus(1L, ""))
                .build();

        taskMapper.addTask(task);

        newTask.setId(task.getId());
        newTask.setStatus(taskMapper.getStatusById(task.getStatus().getId()).getStatus());

        return newTask;
    }

    @Override
    public NewTask getTask(Long taskId) {
        DBTask dbTask = taskMapper.getTaskById(taskId);
        NewTask task = new NewTask.Builder()
                .setId(dbTask.getId())
                .setStartDate(dbTask.getStartDate())
                .setFinishDate(dbTask.getFinishDate())
                .setContent(dbTask.getContent())
                .build();

        if (dbTask.getStatus() == null) {
            task.setStatus("");
        } else {
            task.setStatus(dbTask.getStatus().getStatus());
        }
        return task;
    }

    @Override
    public List<DBStatus> getStatuses() {
        return statusMapper.getStatuses();
    }

    @Override
    public void updateStatus(Long taskId, Long statusId) {
        taskMapper.updateStatus(taskId, statusId);
    }

}
