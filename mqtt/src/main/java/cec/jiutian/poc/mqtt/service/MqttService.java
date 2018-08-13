package cec.jiutian.poc.mqtt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;
@Service
public class MqttService {

	private static List<String> list=new ArrayList<String>();
	
	public void startCase(String message) {
		System.out.println("==== receive  message info ============"+message);
		list.add(message);
	}

	public static List<String> getList() {
		return list;
	}

	public void onMessage(Message message) {
		System.out.println("==== receive  message222 info ============"+message.toString());
		list.add(message.toString());
		
	}

}
