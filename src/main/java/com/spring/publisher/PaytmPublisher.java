package com.spring.publisher;

import com.spring.config.MessagingConfig;
import com.spring.dto.PaymentRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class PaytmPublisher {

    @Autowired
    private RabbitTemplate template;

    public void doPaymentTransaction(PaymentRequest request){
        request.setTransactionId(UUID.randomUUID().toString());
        request.setTxDate(new Date());
        template.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,request);
    }
}
