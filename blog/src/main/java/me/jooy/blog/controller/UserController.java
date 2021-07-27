package me.jooy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/join")
    public String joinForm() {
        return "users/joinForm";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "users/loginForm";
    }

}
