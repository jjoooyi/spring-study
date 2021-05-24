package me.joy.springtest.sample;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) //기본 설정값 MOCK, 내장 톰캣 구동 안 함
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //내장 톰캣 사용 함
//@AutoConfigureMockMvc
@ExtendWith(OutputCaptureExtension.class) //OutputCapture 사용 위한 추가
@WebMvcTest(SampleController.class) //slicing test
class SampleControllerTest {

//----------------------------------MOCK----------------------------------
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    public void helloMock() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("hello joy"))
//                .andDo(print());
//    }

//----------------------------------RANDOM_PORT----------------------------------
//    @Autowired
////    TestRestTemplate testRestTemplate;
//    WebTestClient webTestClient; //webflux 를 dependency 에 추가해야함
//
//    @MockBean
//    SampleService mockSampleService;
//
//    @Test
//    public void helloRandomPort() {
//        when(mockSampleService.getName()).thenReturn("hoy");
//
////        String result = testRestTemplate.getForObject("/hello", String.class);
////        assertThat(result).isEqualTo("hello hoy");
//
//        webTestClient.get().uri("/hello").exchange()
//                .expectStatus().isOk()
//                .expectBody(String.class).isEqualTo("hello hoy");
//
//    }
    
//--------------------------WebMvcTest(SampleController.class) + outputCapture-------------------------
    //slicing Test, 가벼운 테스트, 레이어별로 잘라서 테스트하고 싶을 때

//    @Rule
//    public OutputCaptureRule outputCapture = new OutputCaptureRule();

    @MockBean
    SampleService mockSampleService; //SampleController 만 Bean 등록되어있어서 MockBean 만들어줘야함

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloSlice(CapturedOutput capturedOutput) throws Exception {
        when(mockSampleService.getName()).thenReturn("toy");

        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(content().string("hello toy"));

//        assertThat(outputCapture.toString())
//                .contains("joy log")
//                .contains("skip");

        assertThat(capturedOutput.toString())
                .contains("joy log")
                .contains("skip");
    }

}