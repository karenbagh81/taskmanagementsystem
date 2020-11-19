package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.model.Task;
import com.example.taskmanagementsystem.model.User;
import com.example.taskmanagementsystem.service.inerfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String findAll(Model model) {
        List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "tasks/task-list";
    }

    @GetMapping("/task-create")
    public String createTaskForm(Task task, User user) {
        return "tasks/task-create";
    }

    @PostMapping("/task-create")
    public String createTask(Task task) {
        task.setUser(new User());
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

}
