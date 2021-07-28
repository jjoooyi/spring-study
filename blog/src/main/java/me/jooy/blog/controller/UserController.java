package me.jooy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("users/join")
    public String joinForm() {
        return "users/joinForm";
    }

    @GetMapping("users/login")
    public String loginForm() {
        return "users/loginForm";
    }

}
