package com.service.amq.impl;

import com.common.util.JsonUtil;
import com.service.amq.AmqSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

@Service
public class AMQSenderServiceImpl implements AmqSenderService {

    private static final Logger logger = LoggerFactory.getLogger(AMQSenderServiceImpl.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    //目的地队列的明证，我们要向这个队列发送消息
    @Autowired
    private Destination destinationQueue;

    @Override
    public void sendMsg(String messages) {
        final String msg = JsonUtil.write2JsonStr(messages);
        try{
            jmsTemplate.send(destinationQueue, session -> session.createTextMessage(msg));
        }catch (Exception e){
            logger.error("向队列{}发送消息失败，消息为：{}，exception = {}", destinationQueue, msg,e);
        }
    }
}
