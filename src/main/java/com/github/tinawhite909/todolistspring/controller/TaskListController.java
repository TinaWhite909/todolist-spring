package com.github.tinawhite909.todolistspring.controller;

import com.github.tinawhite909.todolistspring.bean.NewTask;
import com.github.tinawhite909.todolistspring.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskListController {

    @Autowired
    private ITaskService taskService;

    @GetMapping("/newtask")
    public String newTaskForm(Model model) {
        model.addAttribute("newtask", new NewTask());
        return "newtask";
    }

    @GetMapping("/tasklist")
    public String tasklistForm(Model model) {
        model.addAttribute("newtask", taskService.getTasks());
        return "tasklist";
    }

    @PostMapping("/newtask")
    public String newTaskSubmit(@ModelAttribute NewTask newTask, Model model) {
        model.addAttribute("newtask", taskService.addTask(newTask));
        return "task";
    }


}
