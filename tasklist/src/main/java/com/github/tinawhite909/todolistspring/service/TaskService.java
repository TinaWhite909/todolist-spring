package com.github.tinawhite909.todolistspring.service;

import com.github.tinawhite909.todolistspring.bean.DBStatus;
import com.github.tinawhite909.todolistspring.bean.DBTask;
import com.github.tinawhite909.todolistspring.bean.NewTask;
import com.github.tinawhite909.todolistspring.exception.TaskServiceRuntimeException;
import com.github.tinawhite909.todolistspring.mybatis.StatusMapper;
import com.github.tinawhite909.todolistspring.mybatis.TaskMapper;
import com.github.tinawhite909.todolistspring.users.bean.DBUser;
import com.github.tinawhite909.todolistspring.users.bean.NewUser;
import com.github.tinawhite909.todolistspring.users.mybatis.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private UserMapper userMapper;

    @Autowired
    private StatusMapper statusMapper;

    @Override
    public List<NewTask> getTasks() {
        List<NewTask> newTasks = new ArrayList<>();
        List<DBTask> dbTasks = taskMapper.getTasks();
        for (DBTask dbTask : dbTasks) {

            NewUser assigner = new NewUser();
            assigner.setId(dbTask.getAssigner().getId());
            assigner.setUsername(dbTask.getAssigner().getUsername());

            NewUser assigned_to = new NewUser();
            assigned_to.setId(dbTask.getAssigned_to().getId());
            assigned_to.setUsername(dbTask.getAssigned_to().getUsername());

            NewTask task = new NewTask.Builder()
                    .setId(dbTask.getId())
                    .setStartDate(dbTask.getStartDate())
                    .setFinishDate(dbTask.getFinishDate())
                    .setContent(dbTask.getContent())
                    .setAssigner(assigner)
                    .setAssigned_to(assigned_to)
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        DBTask task = new DBTask.Builder()
                .setId(newTask.getId())
                .setStartDate(LocalDate.now())
                .setFinishDate(newTask.getFinishDate())
                .setContent(newTask.getContent())
                .setStatus(new DBStatus(1L, ""))
                .setAssigner(userMapper.getUserByName(username))
                .setAssigned_to(userMapper.getUserById(newTask.getAssigned_to().getId()))
                .build();

        taskMapper.addTask(task);

        newTask.setId(task.getId());
        newTask.setStatus(taskMapper.getStatusById(task.getStatus().getId()).getStatus());

        return newTask;
    }

    @Override
    public NewTask getTask(Long taskId) {
        DBTask dbTask = taskMapper.getTaskById(taskId);

        NewUser assigner = new NewUser();
        assigner.setId(dbTask.getAssigner().getId());
        assigner.setUsername(dbTask.getAssigner().getUsername());

        NewUser assigned_to = new NewUser();
        assigned_to.setId(dbTask.getAssigned_to().getId());
        assigned_to.setUsername(dbTask.getAssigned_to().getUsername());

        NewTask task = new NewTask.Builder()
                .setId(dbTask.getId())
                .setStartDate(dbTask.getStartDate())
                .setFinishDate(dbTask.getFinishDate())
                .setContent(dbTask.getContent())
                .setAssigner(assigner)
                .setAssigned_to(assigned_to)
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
