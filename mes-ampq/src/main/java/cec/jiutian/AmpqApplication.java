package cec.jiutian;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: lwb
 * @Description: 程序的人口
 * @Date: Created in  15:57 2018/8/1
 * @modified By:
 */
public class AmpqApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(AmpqApplication.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-root.xml");
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        template.convertAndSend("hello word");
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            LOGGER.error("thread sleep exception", e.getCause());
        }

        ((ClassPathXmlApplicationContext) ctx).destroy();
        LOGGER.info("AMPQ Application Started.");
    }

}
