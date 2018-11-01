package cec.jiutian.poc.mqtt.inbound;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
@EnableIntegration
@PropertySource("classpath:/application.properties")
public class MqttInboundConfiguration {

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
	public MessageChannel mqttInputChannel() {
		return new DirectChannel();
	}

	@Bean
	public MessageProducer inbound() {
		String clientId = "consumer#1";//
		MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(clientId,
				mqttClientFactory(), env.getProperty("rooutingKey"));
		adapter.setConverter(new DefaultPahoMessageConverter());
		adapter.setQos(Integer.valueOf(env.getProperty("mqtt.defaultQos")));
		adapter.setCompletionTimeout(Integer.valueOf(env.getProperty("mqtt.completionTimeout")));
		adapter.setOutputChannel(mqttInputChannel());

		return adapter;
	}

	@Bean
	@ServiceActivator(inputChannel = "mqttInputChannel", autoStartup = "true")
	public MessageHandler handler() {
		return new SimpleMessageHandler();
	}
	
}
