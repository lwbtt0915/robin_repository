package cec.jiutian.poc.mqtt.inbound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

public class SimpleMessageHandler implements MessageHandler {

	private static final Logger logger = LoggerFactory.getLogger(SimpleMessageHandler.class);

	public void handleMessage(Message<?> message) throws MessagingException {
		System.out.println("=========接收到的消息 ======="+message.getPayload());
		logger.info((String) message.getPayload());
	}

}
