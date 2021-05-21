package hello.springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(locations = "classpath:/test.properties")
//@TestPropertySource(properties = "jooyi.name=jjoooyi")
//@SpringBootTest(properties = "jooyi.name=jjoooyi")
@SpringBootTest
class ApplicationTests {

	@Autowired
	Environment environment;

	@Test
	void contextLoads() {
		Assertions.assertThat(environment.getProperty("jooyi.name")).isEqualTo("testjooyi");
	}

}
