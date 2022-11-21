package com.dongchanglong.cloudalibabaopenfeignconsumer8888.feign;

import com.dongchanglong.cloudalibabacommons.JsonResult;
import com.dongchanglong.cloudalibabacommons.TestEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 此接口就是配合使用OpenFeign的接口，
 * 在此接口中添加@FeignClient接口同时标注
 * 要调用的服务端名称，同时使用与服务提供者
 * 方法签名一致的抽象方法来表示远程调用的
 * 具体内容
 */
@Service
//表示远程调用服务名称
@FeignClient("nacos-provider")
public interface OpenFeignService {
    /**
     * 此方法表示远程调用fallbackList接口
     */
    @PostMapping("fallbackList")
    public JsonResult<String> msbSql(@RequestBody TestEntity testEntity);

    @PostMapping("timeout")
    public JsonResult<String> timeout(@RequestBody TestEntity testEntity);

}
