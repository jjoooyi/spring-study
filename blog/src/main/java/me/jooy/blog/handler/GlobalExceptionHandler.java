package me.jooy.blog.handler;

import me.jooy.blog.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseDto<String> handleArgumentException(IllegalArgumentException e) {
        return new ResponseDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

}
