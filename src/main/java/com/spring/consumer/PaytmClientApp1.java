package com.spring.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.config.MessagingConfig;
import com.spring.dto.PaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaytmClientApp1 {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void processPaymentRequest(PaymentRequest request) throws JsonProcessingException {
        log.info("PaytmClientApp2::processPaymentRequest : {}",new ObjectMapper().writeValueAsString(request));
    }
}
