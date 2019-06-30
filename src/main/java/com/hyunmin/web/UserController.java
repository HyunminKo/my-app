package com.hyunmin.web;

import com.hyunmin.domain.User;
import com.hyunmin.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public String create(User user) {
        System.out.println(user);
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("users",userRepository.findAll());
        return "/user/list";
    }

    @GetMapping("/form")
    public String form() {
        return "/user/form";
    }
    @GetMapping("/{id}/form")
    public String updateForm(@PathVariable Long id, Model model) {
        model.addAttribute("user",userRepository.findById(id).get());
        return "/user/updateForm";
    }
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, User newUser){
        User user = userRepository.findById(id).get();
        user.update(newUser);
        userRepository.save(user);
        return "redirect:/users";
    }
    @GetMapping("/login")
    public String login() {
        return "/user/login";
    }
}
