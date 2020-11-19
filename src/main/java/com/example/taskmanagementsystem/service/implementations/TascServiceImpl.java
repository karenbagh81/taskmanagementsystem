package com.example.taskmanagementsystem.service.implementations;

import com.example.taskmanagementsystem.model.Task;
import com.example.taskmanagementsystem.repository.TaskRepository;
import com.example.taskmanagementsystem.service.inerfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TascServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional
    public Task saveTask(Task task) {
        task.setTaskCreationDate(new Date());
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Task update(Task task) {
        return null;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
}
