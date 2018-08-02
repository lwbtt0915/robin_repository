package cec.jiutian.poc.mqtt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-root.xml")
public class MqttTest {

    @Autowired
    private MqttPahoMessageHandler mqttHandler;

    @Test
    public void sub() {
        // 构建消息
        Message<String> messages = MessageBuilder.withPayload("hello world hello java").setHeader(MqttHeaders.TOPIC, "robot_server").build();
        // 发送消息
        mqttHandler.handleMessage(messages);
    }

    /*@Test
    public void sendMqtt() {
        mqttGateway.sendToMqtt("hello world,welcome java world", "robot_server");
    }*/

}
