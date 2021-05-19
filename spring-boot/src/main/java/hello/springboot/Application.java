package hello.springboot;

import me.jooyi.Holoman;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.io.File;
import java.io.PrintStream;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

//		new SpringApplicationBuilder()
//				.sources(SpringApplication.class)
//				.bannerMode(Banner.Mode.OFF)
//				.run(args);


//		SpringApplication app = new SpringApplication(Application.class);
//		app.setBanner(new Banner() {
//			@Override
//			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//				out.println("===========================");
//				out.println("Jooyi");
//				out.println("===========================");
//			}
//		});
//		app.setBannerMode(Banner.Mode.OFF);
//		app.run(args);


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
