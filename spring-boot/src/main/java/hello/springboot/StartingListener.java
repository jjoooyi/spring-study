package hello.springboot;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class StartingListener implements ApplicationListener<ApplicationStartingEvent> {
//    ApplicationContext 만들어지기 전, 빈으로 등록해도 사용되지 않음
    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("========================");
        System.out.println("Application is starting");
        System.out.println("========================");
    }
}
