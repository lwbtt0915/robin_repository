package cec.jiutian.service.impl;

import cec.jiutian.service.AmqpProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lwb
 * @Description:
 * @Date: Created in 17:21 2018/8/1
 * @modified By:
 */
@Service
public class AmqpProducerImpl implements AmqpProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(AmqpProducerImpl.class);

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void sendDataToQueue(String queueKey, Object object) {
		try {
			System.out.println("=========begin send message============" + queueKey + "," + object.toString());
			amqpTemplate.convertAndSend(queueKey, object);
			System.out.println("========= send message  end============");
		} catch (Exception e) {
			LOGGER.error("send message error:", e.getMessage());
		}

	}
}
