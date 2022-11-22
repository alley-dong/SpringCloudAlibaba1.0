package com.dongchanglong.cloudalibabaconsumer8084;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dongchanglong.cloudalibabacommons.JsonResult;
import com.dongchanglong.cloudalibabacommons.TestEntity;
import com.dongchanglong.cloudalibabaconsumer8084.feign.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class DemoController {
    //服务提供者URL
    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FeignService feignService;


    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",fallbackClass = ConsumerFallbackClass.class,fallback = "nullPointerException2")
    public JsonResult<String> fallback(@PathVariable Long id){
        if(id<=3){
            //通过Ribbon发起远程访问，访问9003/9004
            JsonResult<String> result = restTemplate.getForObject(SERVICE_URL+"/info/"+id,JsonResult.class);
            System.err.println(result.getData());
            return result;
        }else{
            throw new NullPointerException("没有对应的数据记录");
        }
    }


    @PostMapping("/consumer/fallbackList")
    @SentinelResource(value = "fallbackList",fallbackClass = ConsumerFallbackClass.class,fallback = "nullPointerException3")
    public JsonResult<String> fallbackList(@RequestBody TestEntity testEntity){
        if ("1".equals(testEntity.getName())) {
            throw new NullPointerException("excrption");
        }
        //通过Ribbon发起远程访问，访问9003/9004
        JsonResult<String> result = restTemplate.postForObject(SERVICE_URL + "/fallbackList/", testEntity, JsonResult.class);
        System.err.println(result.getData());
        return result;
    }


    public JsonResult<String> fallbackHandler(Long id,Throwable throwable){
        JsonResult<String> result = new JsonResult<>(444,"出现未知商品id");
        return result;
    }


    @GetMapping("/getInfo/{id}")
    public JsonResult<String> getInfo(@PathVariable("id") Long id){
        if (id > 3) {
            throw new NullPointerException("excrption");
        }
        return feignService.msbSql(id);
    }
}
