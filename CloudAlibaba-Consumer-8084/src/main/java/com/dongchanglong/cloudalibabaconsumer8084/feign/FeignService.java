package com.dongchanglong.cloudalibabaconsumer8084.feign;

import com.dongchanglong.cloudalibabacommons.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Service
//@FeignClient(value = "nacos-provider",fallback = FeignServiceImpl.class)
@FeignClient(value = "nacos-provider",fallbackFactory = WebFeignFallbackFactory.class)
public interface FeignService {

    /**
     * 远程调用对应方法
     */
    @GetMapping("info/{id}")
    public JsonResult<String> msbSql(@PathVariable("id") Long id);
}
