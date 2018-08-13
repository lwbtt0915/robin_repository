package cec.jiutian.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lwb
 * @Description: 消费消息
 * @Date: Created in 17:31 2018/8/1
 * @modified By:
 */
public class AmqpConsumerMessage implements MessageListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(AmqpConsumerMessage.class);
	
	private static List<String> list=new ArrayList<String>();

	public void onMessage(Message message) {
		String str = "";
		try {
			list.clear();
			System.out.println("receive message started...");
			str = new String(message.getBody(), "UTF-8");
			list.add(str);
			System.out.println("received message is " + str);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("UnsupportedEncodingException error", e.getCause());
		}
	}

	public static List<String> getList() {
		return list;
	}

}
