package com.github.tinawhite909.todolistspring.service;

import com.github.tinawhite909.todolistspring.bean.DBStatus;
import com.github.tinawhite909.todolistspring.bean.NewTask;

import java.util.List;

public interface ITaskService {

    List<NewTask> getTasks();

    NewTask addTask(NewTask newTask);

    NewTask getTask(Long taskId);

    List<DBStatus> getStatuses();

    void updateStatus(Long taskId, Long statusId);
}
