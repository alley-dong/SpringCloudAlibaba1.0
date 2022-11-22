package com.dongchanglong.cloudalibabaconsumer8084.feign;

import com.dongchanglong.cloudalibabacommons.JsonResult;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService{
    @Override
    public JsonResult<String> msbSql(Long id) {
        return new JsonResult<>(444,"服务降级返回！");
    }
}
