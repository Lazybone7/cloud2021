package com.ithan.springcloud.controller;


import com.ithan.springcloud.entities.CommonResult;
import com.ithan.springcloud.entities.Payment;
import com.ithan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@Slf4j
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入结果为：" + result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功",result);
        }else{
            return new CommonResult(444,"插入数据失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("******插入结果为：" + result);
        if(result != null){
            return new CommonResult(200,"查询数据成功",result);
        }else{
            return new CommonResult(444,"没有对应记录",null);
        }
    }

}
