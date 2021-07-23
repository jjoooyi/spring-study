package me.jooy.blog.test;

import lombok.RequiredArgsConstructor;
import me.jooy.blog.model.User;
import me.jooy.blog.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DummyControllerTest {

    private final UserRepository userRepository;

    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println(user.toString());
        user.setRole("USER");
        User savedUser = userRepository.save(user);
        System.out.println(savedUser.toString());
        return "success";
    }
}
