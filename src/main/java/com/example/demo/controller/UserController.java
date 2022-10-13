package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService service;

    public UserService getService() {
        return service;
    }

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping()
    public String printUsers(Model model) {
        model.addAttribute("users", service.readUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", service.getUser(id));
        return "userInfo";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        service.saveUser(user);
        return ("redirect:/users");
    }

    @GetMapping("/{id}/edit")
    public String update(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", service.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute ("user") User user, @PathVariable("id") long id){
        service.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", service.getUser(id));
        return "delete";
    }
    @DeleteMapping("/{id}")
    public String confirmDeleteUser(@ModelAttribute ("user") User user,@PathVariable("id") long id){
        service.deleteUser(id);
        return "redirect:/users";
    }
}
