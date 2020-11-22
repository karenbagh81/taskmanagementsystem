package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.enums.TaskStatus;
import com.example.taskmanagementsystem.exception.NotFoundException;
import com.example.taskmanagementsystem.model.Task;
import com.example.taskmanagementsystem.model.User;
import com.example.taskmanagementsystem.service.inerfaces.TaskService;
import com.example.taskmanagementsystem.service.inerfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String findAll(Model model) {
        List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "tasks/task-list";
    }

    @GetMapping("/task-create")
    public String createTaskForm(Task task, Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("task", task);
        return "tasks/task-create";
    }

    @PostMapping("/task-create")
    public String createTask(Task task) throws NotFoundException {
        //task.setUser(userService.findById(1)); // *******test!!!*******
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/task-delete/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskService.deleteById(id);
        return "redirect:/tasks";
    }

    @GetMapping("/task-update/{id}")
    public String updateTaskForm(@PathVariable("id") int id, Model model) throws NotFoundException {
        Task task = taskService.findById(id);
        model.addAttribute("task", task);
        return "tasks/task-update";
    }

    @PostMapping("/task-update")
    public String updateTask(Task task) throws NotFoundException {
        task.setUser(userService.findById(1)); // ******test!!!******
        taskService.update(task);
        return "redirect:/tasks";
    }

}
