package com.dongchanglong.cloudalibabaconsumer8084.feign;

import com.dongchanglong.cloudalibabacommons.JsonResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class WebFeignFallbackFactory implements FallbackFactory<FeignService> {
    @Override
    public FeignService create(Throwable throwable) {
        return new FeignService() {
            @Override
            public JsonResult<String> msbSql(Long id) {
                // 出现异常，自定义返回内容，保证接口安全
                return new JsonResult<>(666,throwable.getMessage());
            }
        };
    }
}
