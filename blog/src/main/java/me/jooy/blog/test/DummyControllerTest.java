package me.jooy.blog.test;

import lombok.RequiredArgsConstructor;
import me.jooy.blog.model.RoleType;
import me.jooy.blog.model.User;
import me.jooy.blog.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Supplier;

@RequiredArgsConstructor
@RestController
@RequestMapping("/dummy")
public class DummyControllerTest {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User detail(@PathVariable int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저는 없습니다. id: " + id));
        return user;
    }

    //한 페이지 당 2건의 데이터를 리턴받아 볼 예정 // 페이징
    @GetMapping("/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> pagingUsers = userRepository.findAll(pageable);
        List<User> users = pagingUsers.getContent();
        return users;
    }

    @PostMapping("/join")
    public String join(User user) {
        System.out.println(user.toString());
        user.setRole(RoleType.USER);
        User savedUser = userRepository.save(user);
        System.out.println(savedUser.toString());
        return "success";
    }

    @Transactional
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("수정에 실패하였습니다."));
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());
//        userRepository.save(user);
        return null;
    }
}
