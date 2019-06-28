package com.hyunmin.web;

import com.hyunmin.domain.User;
import com.hyunmin.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/create")
    public String create(User user) {
        System.out.println(user);
        userRepository.save(user);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("users",userRepository.findAll());
        return "list";
    }
}
