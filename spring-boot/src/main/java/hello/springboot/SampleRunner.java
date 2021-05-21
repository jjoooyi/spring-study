package hello.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) //ApplicationRunner 가 여러개일 경우 우선순위 정할 수 있음
public class SampleRunner implements ApplicationRunner { //애플리케이션 실행한 뒤 뭔가 실행하고 싶을 때!

    @Value("${jooyi.fullName}")
    private String name;

    @Value("${jooyi.age}")
    private int age;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("============");
        System.out.println(name);
        System.out.println(age);
        System.out.println("============");
    }
}
