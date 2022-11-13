package com.dongchanglong.cloudalibabaprovider9003.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResult {

    private int code;
    private Object data;
    private String message;


    public BaseResult(int code,Object data,String message){
        this.code = code;
        this.data = data;
        this.message = message;
    }

}
