package cec.jiutian.poc.mqtt;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cec.jiutian.poc.mqtt.outbound.MqttMessageProducer;
import cec.jiutian.poc.mqtt.outbound.MqttOutboundConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { MqttOutboundConfiguration.class })
@ContextConfiguration("classpath:spring-mqtt-producer.xml")
public class MqttMessageSendTest {

	@Autowired
	private MqttMessageProducer msgProducer;

	private String topic = "demo.wuhan.send.to.mqtt";

	@Test
	public void pub() throws Exception {
		
		System.out.println("**************发送消息开始***************");
		//msgProducer.sendToMqtt("hello java world, welcome python home@111");
		msgProducer.sendToMqtt("<body>harry potter</body>");
		/*msgProducer.sendToMqtt("<body>harry potter</body>");
		msgProducer.sendToMqtt("<body>harry potter</body>");
		msgProducer.sendToMqtt("<body>harry potter</body>");
		msgProducer.sendToMqtt("<body>harry potter</body>");*/
		//qos=1
		msgProducer.sendToMqtt(topic, 1, "<body>harry potter</body>");
		/*msgProducer.sendToMqtt(topic, 1, "<body>harry potter</body>");
		msgProducer.sendToMqtt(topic, 1, "<body>harry potter</body>");
		msgProducer.sendToMqtt(topic, 1, "<body>harry potter</body>");
		msgProducer.sendToMqtt(topic, 1, "<body>harry potter</body>");
		msgProducer.sendToMqtt(topic, 1, "<body>harry potter</body>");*/
		//msgProducer.sendToMqtt(topic, 1, "hello java world, welcome python home@222");
		System.out.println("=====================接收消息结束==============");
		//TimeUnit.MINUTES.sleep(2);
	}

}
