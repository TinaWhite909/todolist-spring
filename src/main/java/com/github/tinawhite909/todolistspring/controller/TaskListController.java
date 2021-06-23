package com.github.tinawhite909.todolistspring.controller;

import com.github.tinawhite909.todolistspring.bean.NewTask;
import com.github.tinawhite909.todolistspring.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/editstatus/{taskId}")
    public String editStatus(@PathVariable Long taskId, Model model) {
        model.addAttribute("task", taskService.getTask(taskId));
        model.addAttribute("statuses", taskService.getStatuses());
        return "editstatus";
    }

    @PostMapping("/editstatus/{taskId}")
    public String updateStatus(@PathVariable Long taskId, @ModelAttribute("status_id") Long statusId, Model model) {
//        model.addAttribute("task", taskService.getTask(taskId));
//        model.addAttribute("statuses", taskService.getStatuses());
        taskService.updateStatus(taskId, statusId);
        return "redirect:/editstatus/" + taskId;
    }

}
