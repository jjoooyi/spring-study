package hello.springboot;

import me.jooyi.Holoman;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

//		SpringApplication application = new SpringApplication(Application.class);
//		application.setWebApplicationType(WebApplicationType.NONE);
//		application.run(args);

	}

//	@Bean
//	public Holoman holoman() {
//		Holoman holoman = new Holoman();
//		holoman.setName("Park");
//		holoman.setHowLong(45);
//		return holoman;
//	}

}
