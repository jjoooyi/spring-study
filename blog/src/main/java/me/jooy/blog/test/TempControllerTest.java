package me.jooy.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

    // application.yml 에서 prefix/suffix 설정했기 때문에 동작하지 않음
    @GetMapping("/temp/home")
    public String tempHome() {
        System.out.println("tempHome()");
        return "/home.html";
    }

    // 원래 스프링에서는 jsp 를 지원하지 않기때문에.. 노란줄은.. 어쩔 수 없나보다 ... ㅠㅠ...
    @GetMapping("/temp/jsp")
    public String tempJsp() {
        System.out.println("tempJsp()");
        return "test";
    }
}
