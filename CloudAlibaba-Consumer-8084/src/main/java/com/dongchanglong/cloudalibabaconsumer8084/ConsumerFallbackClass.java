package com.dongchanglong.cloudalibabaconsumer8084;

import com.dongchanglong.cloudalibabacommons.JsonResult;
import com.dongchanglong.cloudalibabacommons.TestEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public class ConsumerFallbackClass {
    // 静态方法
    public static JsonResult<String> nullPointerException1(@PathVariable Long id){
        JsonResult<String> result = new JsonResult<>(444,"NullPointerException1：系统异常，请稍后重试！");
        return result;
    }
    public static JsonResult<String> nullPointerException2(@PathVariable Long id){
        JsonResult<String> result = new JsonResult<>(444,"NullPointerException2：系统异常，请稍后重试！");
        return result;
    }
    public static JsonResult<String> nullPointerException3(@RequestBody TestEntity testEntity){
        JsonResult<String> result = new JsonResult<>(444,"NullPointerException3：系统异常，请稍后重试！");
        return result;
    }
}
