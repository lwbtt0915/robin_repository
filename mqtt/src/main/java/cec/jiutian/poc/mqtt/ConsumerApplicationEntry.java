package cec.jiutian.poc.mqtt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cec.jiutian.poc.mqtt.inbound.MqttInboundConfiguration;

public class ConsumerApplicationEntry {

	public static void main(String[] args) throws Exception {
		Logger logger = LoggerFactory.getLogger(ConsumerApplicationEntry.class);

		//ApplicationContext ctx = new AnnotationConfigApplicationContext(MqttInboundConfiguration.class);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mqtt-consumer.xml");

		logger.info("Consumer Started.");
	}
}
