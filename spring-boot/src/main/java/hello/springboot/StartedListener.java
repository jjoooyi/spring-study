package hello.springboot;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartedListener implements ApplicationListener<ApplicationStartedEvent> {
//    ApplicationContext 만들어진 후
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("========================");
        System.out.println("Application is started");
        System.out.println("========================");
    }
}
