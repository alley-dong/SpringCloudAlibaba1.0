package com.dongchanglong.cloudalibabaprovider9004;

import com.dongchanglong.cloudalibabacommons.JsonResult;
import com.dongchanglong.cloudalibabacommons.TestEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class DataController {
    @Value("${server.port}")
    private String serverPort;

    //模仿数据库存储数据
    public static HashMap<Long,String> hashMap = new HashMap<>();
    static {
        hashMap.put(1l,"鼠标1");
        hashMap.put(2l,"键盘1");
        hashMap.put(3l,"耳机1");
    }

    @GetMapping("info/{id}")
    public JsonResult<String> msbSql(@PathVariable("id") Long id){
        JsonResult<String> result = new JsonResult(200,hashMap.get(id));
        return result;
    }

    @PostMapping("fallbackList")
    public JsonResult<String> msbSql(@RequestBody TestEntity testEntity){
        JsonResult<String> result = new JsonResult(200,"ServerPort 9004:"+hashMap.get(1L));
        return result;
    }

    @PostMapping("timeout")
    public JsonResult<String> timeout(@RequestBody TestEntity testEntity){
        JsonResult<String> result = new JsonResult(200,"ServerPort 9004");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
