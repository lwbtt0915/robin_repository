package cec.jiutian.poc.mqtt.outbound;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.GatewayHeader;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttMessageProducer {
	
	void sendToMqtt(String payload);

	//@Gateway(requestChannel = "inputB", headers = @GatewayHeader(name = "thing1", value="thing2"))
	void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, String payload);

	//@Gateway(requestChannel = "inputA", replyTimeout = 2, requestTimeout = 200)
	void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, String payload);
}
