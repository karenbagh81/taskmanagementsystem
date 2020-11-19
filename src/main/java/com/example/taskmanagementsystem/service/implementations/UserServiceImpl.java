package com.example.taskmanagementsystem.service.implementations;

import com.example.taskmanagementsystem.exception.DuplicateException;
import com.example.taskmanagementsystem.exception.NotFoundException;
import com.example.taskmanagementsystem.model.User;
import com.example.taskmanagementsystem.repository.UserRepository;
import com.example.taskmanagementsystem.service.inerfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(int id) throws NotFoundException {
        User user = userRepository.getOne(id);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        return userRepository.getOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        User user1 = userRepository.getByEmail(user.getEmail());
        if (user1 != null) {
            throw new DuplicateException("Duplicated user data");
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        User user = userRepository.getByEmail(email);
        if (user == null) {
            throw new NotFoundException("User is not found");
        }
        return user;
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }
}
