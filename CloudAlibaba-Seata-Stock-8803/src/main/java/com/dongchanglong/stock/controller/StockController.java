package com.dongchanglong.stock.controller;

import com.dongchanglong.stock.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StockController {
    @Resource
    private StockService stockService;

    @GetMapping("/stock/decr")
    public String decrement(){
        stockService.decr();
        return "库存-1";
    }

}
