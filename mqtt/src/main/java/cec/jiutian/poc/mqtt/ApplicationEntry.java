package cec.jiutian.poc.mqtt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationEntry {

    public static void main(String[] args) throws Exception {
        Logger logger = LoggerFactory.getLogger(ApplicationEntry.class);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-root.xml");

        logger.info("CHOT MMM Application Started.");
    }


}
