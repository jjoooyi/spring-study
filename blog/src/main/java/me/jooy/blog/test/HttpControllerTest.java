package me.jooy.blog.test;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/http")
public class HttpControllerTest {

    @GetMapping("/get")
    public String getTest(Member member) {
        return "get request" + member.getId() + "," + member.getUsername();
    }

    @PostMapping("/post")
    public String postTest(@RequestBody Member member) { // raw data body 에 넣어서 전송하여 받을 수 있음 => MessageConverter
        return "post request";
    }

    @PutMapping("/put")
    public String putTest() {
        return "put request";
    }

    @DeleteMapping("/delete")
    public String deleteTest() {
        return "delete request";
    }
}
