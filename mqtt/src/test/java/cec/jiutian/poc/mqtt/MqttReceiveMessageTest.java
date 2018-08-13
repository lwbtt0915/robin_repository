package cec.jiutian.poc.mqtt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cec.jiutian.poc.mqtt.service.MqttService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-root.xml")
public class MqttReceiveMessageTest {
	
	@Test
	public void receiveMessageTest() {
		AbstractApplicationContext  ctx = new ClassPathXmlApplicationContext("classpath*:spring-root.xml");
		MqttService mqttService=(MqttService) ctx.getBean("mqttCaseService");
		System.out.println("*******  Receive message is *****"+mqttService.getList().toString());
	}
	
}
