package me.jooy.blog.controller.api;

import lombok.RequiredArgsConstructor;
import me.jooy.blog.dto.ResponseDto;
import me.jooy.blog.model.RoleType;
import me.jooy.blog.model.User;
import me.jooy.blog.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseDto<Integer> save(@RequestBody User user) {
        //실제로 DB에 insert 하고 아래에서 return
        user.setRole(RoleType.USER);
        userService.save(user);
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }

}
