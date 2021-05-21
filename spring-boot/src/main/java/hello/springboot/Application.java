package hello.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);

//		new SpringApplicationBuilder()
//				.sources(SpringApplication.class)
//				.bannerMode(Banner.Mode.OFF)
//				.run(args);


		SpringApplication app = new SpringApplication(Application.class);
		app.addListeners(new StartingListener());
//		app.setBanner(new Banner() {
//			@Override
//			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//				out.println("===========================");
//				out.println("Jooyi");
//				out.println("===========================");
//			}
//		});
//		app.setBannerMode(Banner.Mode.OFF);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);

	}

//	@Bean
//	public Holoman holoman() {
//		Holoman holoman = new Holoman();
//		holoman.setName("Park");
//		holoman.setHowLong(45);
//		return holoman;
//	}

}
