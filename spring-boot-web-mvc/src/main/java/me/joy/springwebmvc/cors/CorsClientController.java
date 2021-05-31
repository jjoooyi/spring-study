package me.joy.springwebmvc.cors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CorsClientController {

    @GetMapping("/cors")
    public String cors() {
        return "cors";
    }

}
