package cec.jiutian.poc.mqtt.outbound;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
@EnableIntegration
@IntegrationComponentScan("cec.jiutian.poc.mqtt.outbound")
@PropertySource("classpath:/application.properties")
public class MqttOutboundConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public MqttPahoClientFactory mqttClientFactory() {
		DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();

		MqttConnectOptions options = new MqttConnectOptions();
		options.setServerURIs(new String[] { env.getProperty("mqtt.url") });
		options.setUserName(env.getProperty("mqtt.username"));
		options.setPassword(env.getProperty("mqtt.password").toCharArray());
		options.setCleanSession(Boolean.valueOf(env.getProperty("mqtt.cleanSession")));//

		factory.setConnectionOptions(options);
		return factory;
	}

	@Bean
	@ServiceActivator(inputChannel = "mqttOutboundChannel")
	public MessageHandler mqttOutbound() {
		String clientId = "producer#1";//
		MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(clientId, mqttClientFactory());
		messageHandler.setAsync(Boolean.valueOf(env.getProperty("mqtt.async")));
		messageHandler.setDefaultTopic(env.getProperty("rooutingKey"));
		messageHandler.setDefaultQos(Integer.valueOf(env.getProperty("mqtt.defaultQos")));
		return messageHandler;
	}

	@Bean
	public MessageChannel mqttOutboundChannel() {
		return new DirectChannel();
	}

}
