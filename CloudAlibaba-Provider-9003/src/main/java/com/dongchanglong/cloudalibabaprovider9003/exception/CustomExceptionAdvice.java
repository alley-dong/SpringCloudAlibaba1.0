package com.dongchanglong.cloudalibabaprovider9003.exception;

import com.dongchanglong.cloudalibabacommons.JsonResult;
import org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@ControllerAdvice
public class CustomExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionAdvice.class);

    /**
     * 处理与用户相关的业务异常
     *
     * @return
     */
    @ExceptionHandler(MyException.class)
    public BaseResult UserExceptionHandler(HttpServletRequest request, MyException e) {
        logger.error("用户信息异常：Host:{} invoke URL:{},错误信息：{}", request.getRemoteHost(), request.getRequestURL(), e.getMessage());
        return new BaseResult(e.getCode(), false, e.getMessage());
    }


    /**
     * 处理与用户相关的业务异常
     *
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public JsonResult NullPointerExceptionHandler(HttpServletRequest request, NullPointerException nullEx) {
        //打印异常信息。空指针异常比较特殊，必须放在下面一行代码 log.info() 之前才可以正常打印出异常类的路径(暂不知为何)
        printStackTraceInfo(nullEx.getStackTrace());
        return new JsonResult(200, false, "空指针异常");
    }


    /**
     * <p>打印异常栈追踪的信息</p >
     * @author hkl
     * @date 2021/11/27
     * @param stackTraceElements 追踪到的栈异常信息集合
     */
    private void printStackTraceInfo(StackTraceElement[] stackTraceElements){
        for(StackTraceElement stackTraceElement : Optional.ofNullable(stackTraceElements).orElse(new StackTraceElement[0])){
            if(stackTraceElement != null){
                String errMsg = String.valueOf(stackTraceElement);
                //只打印此项目业务中捕捉到的异常信息
                if(errMsg.contains("com.dongchanglong")){
                    logger.error(errMsg);
                }
            }
        }
    }

}