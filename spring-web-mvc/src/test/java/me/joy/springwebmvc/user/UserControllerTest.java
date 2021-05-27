package me.joy.springwebmvc.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test // 주로... json
    public void createUser_JSON() throws Exception {
        String userJson = "{\"username\":\"joy\", \"password\":\"1234\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/users/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(userJson))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.username", is(equalTo("joy"))))
                    .andExpect(jsonPath("$.password", is(equalTo("1234"))));
    }

    @Test //요청 JSON, 응답 XML, pom.xml 에 dependency 추가(XML 메시지 컨버터 추가)
    public void createUser_XML() throws Exception {
        String userJson = "{\"username\":\"joy\", \"password\":\"1234\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/users/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_XML)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(xpath("/User/username").string("joy"))
                .andExpect(xpath("/User/password").string("1234"));
    }

}
