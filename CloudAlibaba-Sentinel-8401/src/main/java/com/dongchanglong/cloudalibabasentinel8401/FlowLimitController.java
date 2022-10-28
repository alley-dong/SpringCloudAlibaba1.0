package com.dongchanglong.cloudalibabasentinel8401;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {
    @Autowired
    TestService testService;
    @GetMapping("/testA")
    public String testA(){
        log.info(Thread.currentThread().getName()+"：testA");
        return testService.common();
    }

    @GetMapping("/testB")
    public String testB(){
        return testService.common();
    }

    @GetMapping("/testC")
    public String testC(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return testService.common();
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "handler_HotKey")
    public String testHotKey(@RequestParam(value = "hot1",required = false) String hot1,
                             @RequestParam(value = "hot2",required = false)String hot2,
                             @RequestParam(value = "hot13",required = false) String hot3){
        return "----testHotKey";
    }

    //处理异常方法，方法签名要和对应的接口方法保持一致
    public String handler_HotKey(String hot1, String hot2, String hot3, BlockException exception){
        return "系统繁忙稍后重试。。";
    }


    @GetMapping("/bycustomer")
    @SentinelResource(value = "bycustomer",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException1")
    public String bycustomer(){
        return "-----bycustomer";
    }

}