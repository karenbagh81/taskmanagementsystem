package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.exception.NotFoundException;
import com.example.taskmanagementsystem.model.User;
import com.example.taskmanagementsystem.service.inerfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/users")
@RolesAllowed(value = "MANAGER")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users/user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){

        return "users/user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) throws NotFoundException, javassist.NotFoundException {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "users/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.update(user);
        return "redirect:/users";
    }
}
