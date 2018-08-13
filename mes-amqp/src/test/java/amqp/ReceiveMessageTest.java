package amqp;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cec.jiutian.service.impl.AmqpConsumerMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-root.xml")
public class ReceiveMessageTest {
	
	/****
	 * 收消息测试
	 * 
	 */
	@Test
	public void receiveTest() {
		List<String> list=AmqpConsumerMessage.getList();
		System.out.println(" The second time receive message +++"+list.toString());
	}
}
