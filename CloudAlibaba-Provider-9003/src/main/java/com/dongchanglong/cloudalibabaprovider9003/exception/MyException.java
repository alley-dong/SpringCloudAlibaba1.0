package com.dongchanglong.cloudalibabaprovider9003.exception;

public class MyException extends RuntimeException{

    private int code;

    public MyException(ResponseEnum userResponseEnum){
        // 返回自定义异常信息内容
        super(userResponseEnum.getMessage());
        this.code = userResponseEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

}
