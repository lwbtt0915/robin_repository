package cec.jiutian.service;

/**
 * @Author: lwb
 * @Description: 消息提供接口
 * @Date: Created in  17:20 2018/8/1
 * @modified By:
 */
public interface AmqpProducer {
    /**
     * 发送消息到指定队列
     *
     * @param queueKey
     * @param object
     */
    void sendDataToQueue(String queueKey, Object object);

}
