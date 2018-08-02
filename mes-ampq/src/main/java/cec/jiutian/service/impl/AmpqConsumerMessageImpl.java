package cec.jiutian.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;

/**
 * @Author: lwb
 * @Description: 消费消息
 * @Date: Created in  17:31 2018/8/1
 * @modified By:
 */
public class AmpqConsumerMessageImpl implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(AmpqConsumerMessageImpl.class);

    public void onMessage(Message message) {
        String str = "";
        try {
            str = new String(message.getBody(), "UTF-8");
            System.out.println("received message is "+str);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("UnsupportedEncodingException error", e.getStackTrace());
        }

    }
}
