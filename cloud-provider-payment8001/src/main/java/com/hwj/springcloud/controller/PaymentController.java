package com.hwj.springcloud.controller;

import com.hwj.springcloud.entities.CommonResult;
import com.hwj.springcloud.entities.Payment;
import com.hwj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payments")
    public CommonResult create(Payment payment) {

        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);

        if(result>0) {

            return new CommonResult(200,"插入数据库成功",result);
        }
        else {

            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/payments/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {

        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果hhh："+payment);

        if(payment!=null) {

            return new CommonResult(200,"查询成功",payment);
        }
        else {

            return new CommonResult(444,"没有对应记录，查询ID："+id,null);
        }
    }
}
