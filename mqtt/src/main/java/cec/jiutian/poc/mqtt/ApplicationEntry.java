package cec.jiutian.poc.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cec.jiutian.poc.mqtt.service.MqttService;

public class ApplicationEntry {
	
	
	private static String hostName="tcp://192.168.1.152:1883";
	private static String username= "wuhanalarm";
	private static String password= "alarm!123";
	private static String subscribeTopic= "amq.topic" ;
	private static MqttClient client ;
	
	public static void main(String[] args) throws Exception {
		Logger logger = LoggerFactory.getLogger(ApplicationEntry.class);

		AbstractApplicationContext  ctx = new ClassPathXmlApplicationContext("classpath*:spring-root.xml");
		//subscribe();
		//ctx.close();
		
		
		MqttService mqttService=(MqttService) ctx.getBean("mqttCaseService");
		System.out.println("*******  Receive message is *****"+mqttService.getList().toString());
		logger.info("ApplicationEntry  Started.");
	}
	
	 public static String subscribe() {

	        try {   
	            //创建MqttClient  
	        	client=new MqttClient(hostName,"11");   
	            client.setCallback(new MqttCallback(){
					
					@Override
					public void deliveryComplete(IMqttDeliveryToken token) {
						 //publish后会执行到这里
	                    long messageId = token.getMessageId();
	                    System.out.println("messageId=: " + messageId);
					}
					@Override
					public void messageArrived(String topic, MqttMessage message) throws Exception {
						String payload = new String(message.getPayload());
					    System.out.println("Payload : " + payload);
					}
					@Override
					public void connectionLost(Throwable cause) {

					}
	            	
	            });
	            
	            MqttConnectOptions conOptions = new MqttConnectOptions();   
	            conOptions.setUserName(username);
	            conOptions.setPassword(password.toCharArray());
	            conOptions.setCleanSession(false);   
	            client.connect(conOptions);   
	            client.subscribe(subscribeTopic, 1); 
	            boolean isSuccess =client.isConnected();
	            System.out.println("连接状态:"+isSuccess);
	            //client.disconnect();   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	            return "failed";   
	        }   
	        
	        return "success";   
	 }
	
}
