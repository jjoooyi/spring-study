package me.jooy.blog.service;

import lombok.RequiredArgsConstructor;
import me.jooy.blog.model.User;
import me.jooy.blog.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
}
