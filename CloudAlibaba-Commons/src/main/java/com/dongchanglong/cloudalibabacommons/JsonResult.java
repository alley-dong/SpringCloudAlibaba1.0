package com.dongchanglong.cloudalibabacommons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class JsonResult<T> {

    private Integer code;
    private T data;
    private String message;

    public JsonResult(){
    }

    public JsonResult(int code,T data){
        this.code = code;
        this.data = data;
    }

    public JsonResult(int code,T data,String message){
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
