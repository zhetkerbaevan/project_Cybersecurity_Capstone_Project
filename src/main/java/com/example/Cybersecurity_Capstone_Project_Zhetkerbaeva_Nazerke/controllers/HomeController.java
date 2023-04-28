package com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.controllers;

import com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.entities.Users;
import com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    UsersService userService;
    @GetMapping("/")
    public String main() {
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(@RequestParam(name = "username_field") String username,
                           @RequestParam(name = "password_field") String password) {
        Users newUser = new Users();
        newUser.setUsername(username);
        newUser.setPassword(password);

        if(userService.createUser(newUser) != null){
            return "redirect:/login";
        }
        return "register";
    }

    @GetMapping("/message_center")
    public String message_center() {
        return "message_center";
    }

    @GetMapping("/my_messages")
    public String my_messages() {
        return "my_messages";
    }

    @GetMapping("/send_message")
    public String send_message() {
        return "send_message";
    }

    @PostMapping("/send_message")
    public String send_message_to() {
        return "send_message";
    }

}
