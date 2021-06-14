package com.github.tinawhite909.todolistspring.service;

import com.github.tinawhite909.todolistspring.bean.NewTask;

import java.util.List;

public interface ITaskService {

    List<NewTask> getTasks();

    NewTask addTask(NewTask newTask);
}
