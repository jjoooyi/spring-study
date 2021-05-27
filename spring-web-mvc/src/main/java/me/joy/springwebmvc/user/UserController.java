package me.joy.springwebmvc.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/users")
    public String hello() {
        return "users";
    }

//    @PostMapping("/users")
//    public @ResponseBody User create(@RequestBody User user) { //RestController 여서 @ResponseBody 안붙여도됨
//        return null;
//    }

    @PostMapping("/users/create")
    public User create(@RequestBody User user) {
        return user;
    }

}
