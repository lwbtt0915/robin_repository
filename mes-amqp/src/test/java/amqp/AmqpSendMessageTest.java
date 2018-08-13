package amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-root.xml")
public class AmqpSendMessageTest {
	

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	/***
	 * 发送消息测试
	 */
	@Test
	public void sendMessge() {
		rabbitTemplate.convertAndSend("++++++++++++++welcome rabbitMQ message  server +++++++++++++++++++++++");
	}
	
}
