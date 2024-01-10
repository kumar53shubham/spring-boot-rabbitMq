package com.spring.controller;

import com.spring.dto.PaymentRequest;
import com.spring.publisher.PaytmPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaytmController {

    @Autowired
    private PaytmPublisher paytmPublisher;

    @PostMapping("/rabbitmq/pay")
    public String payUsingUPI(@RequestBody PaymentRequest request){
        paytmPublisher.doPaymentTransaction(request);
        return "payment request in process!!";
    }
}
