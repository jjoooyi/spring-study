package hello.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class LogTestRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(LogTestRunner.class);

    @Autowired
    private TestProperties testProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("-=-=-=-=-=-=-=-=-=-=-=-");
        logger.debug(testProperties.getName());
        logger.debug(testProperties.getFullName());
        logger.debug("-=-=-=-=-=-=-=-=-=-=-=-");
    }
}
