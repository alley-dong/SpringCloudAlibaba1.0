package com.dongchanglong.cloudalibabaopenfeignconsumer8888;

import com.dongchanglong.cloudalibabacommons.JsonResult;
import com.dongchanglong.cloudalibabacommons.TestEntity;
import com.dongchanglong.cloudalibabaopenfeignconsumer8888.feign.OpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Autowired
    private OpenFeignService openFeignService;

    @PostMapping("fallbackList")
    public JsonResult<String> msbSql(@RequestBody TestEntity testEntity){
        return openFeignService.msbSql(testEntity);
    }
}
