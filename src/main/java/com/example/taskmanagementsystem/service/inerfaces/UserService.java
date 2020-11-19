package com.example.taskmanagementsystem.service.inerfaces;

import com.example.taskmanagementsystem.model.User;
import javassist.NotFoundException;

import java.util.List;

public interface UserService {

    User findById(int id) throws com.example.taskmanagementsystem.exception.NotFoundException;

    List<User> findAll();

    User saveUser(User user);

    void deleteById(int id);

    User getByEmail(String email) throws com.example.taskmanagementsystem.exception.NotFoundException;

    User update(User user);
}
