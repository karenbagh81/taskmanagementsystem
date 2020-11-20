package com.example.taskmanagementsystem.service.implementations;

import com.example.taskmanagementsystem.exception.NotFoundException;
import com.example.taskmanagementsystem.model.Task;
import com.example.taskmanagementsystem.model.User;
import com.example.taskmanagementsystem.repository.TaskRepository;
import com.example.taskmanagementsystem.service.inerfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        taskRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Task update(Task task) {
        task.setTaskUpdateDate(new Date());
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(int id) throws NotFoundException {
        Optional<Task> task = taskRepository.findById(id);
        if (!task.isPresent()) {
            throw new NotFoundException("User not found");
        }
        return task.get();
    }
}
