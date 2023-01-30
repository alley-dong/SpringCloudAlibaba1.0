package com.dongchanglong.order.controller;

import com.dongchanglong.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public String create(){
        orderService.create();
        return "生成订单";
    }
}
