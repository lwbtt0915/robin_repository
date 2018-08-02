package cec.jiutian.poc.mqtt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author: lwb
 * @Description:
 * @Date: Created in  17:06 2018/7/31
 * @modified By:
 */
public class MqttConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MqttConsumerService.class);

    public void startMessage(String message) {
        LOGGER.info(message);
        System.out.println(message);
    }

   /*
        Java Configuration
    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[]{"tcp://host1:1883", "tcp://host2:1883"});
        options.setUserName("username");
        options.setPassword("password".toCharArray());
        factory.setConnectionOptions(options);
        return factory;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound() {
        MqttPahoMessageHandler messageHandler =
                new MqttPahoMessageHandler("testClient", mqttClientFactory());
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic("testTopic");
        return messageHandler;
    }

    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }
*/
}
