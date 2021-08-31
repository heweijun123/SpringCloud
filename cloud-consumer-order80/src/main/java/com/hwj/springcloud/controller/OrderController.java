package com.hwj.springcloud.controller;


import com.hwj.springcloud.entities.CommonResult;
import com.hwj.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "https://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payments")
    public CommonResult create(Payment payment) {

        return restTemplate.postForObject(PAYMENT_URL+"/payments",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payments/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {

        return restTemplate.getForObject(PAYMENT_URL+"/payments/"+id,CommonResult.class);
    }
}
