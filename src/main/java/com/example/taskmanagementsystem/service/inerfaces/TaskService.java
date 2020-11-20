package com.example.taskmanagementsystem.service.inerfaces;

import com.example.taskmanagementsystem.exception.NotFoundException;
import com.example.taskmanagementsystem.model.Task;

import java.util.List;

public interface TaskService {

    Task saveTask(Task task);

    void deleteById(int id);

    Task update(Task task);

    List<Task> findAll();

    Task findById(int id) throws NotFoundException;
}
