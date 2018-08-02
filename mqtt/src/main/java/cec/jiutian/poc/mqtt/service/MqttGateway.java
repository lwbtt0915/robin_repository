package cec.jiutian.poc.mqtt.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * @Author: lwb
 * @Description:配置MqttGateway消息推送接口类
 * @Date: Created in  14:16 2018/7/31
 * @modified By:
 */
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {
    /**
     * @param data  发送的消息内容
     * @param topic 主题
     */
    void sendToMqtt(String data, @Header(MqttHeaders.TOPIC) String topic);
}
