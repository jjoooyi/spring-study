package me.joy.springcorsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCorsServerApplication {

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/cors")
    public String cors() {
        return "cors";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCorsServerApplication.class, args);
    }

}
