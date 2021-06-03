package com.ksn.handle;

import base.AgileException;
import base.WebResponse;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ruanjiangke@mxftech.com
 * @Date 19-4-12 上午11:51
 * @Desc 异常处理
 */
@Slf4j
@ControllerAdvice(basePackages = "com.mxftech.pcsp",annotations = {Controller.class, RestController.class})
public class ControllerExceptionHandler {

    /**
     * 自定义异常处理
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(AgileException.class)
    @ResponseBody
    public WebResponse<String> agileExceptionHandle(AgileException e, HttpServletRequest request){
        log.error("请求路径："+request.getRequestURI()+ StrUtil.COMMA+ "An exception occurred to the system. The log record is as follows：",e);
        return new WebResponse<>(e.getStatus().value(),e.getErrMsg(),e.getClass().getSimpleName());
    }

    /**
     * 其他异常处理
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public WebResponse<String> exceptionHandle(Exception e, HttpServletRequest request){
        log.error("请求路径："+request.getRequestURI()+ StrUtil.COMMA+ "An exception occurred to the system. The log record is as follows：",e);
        return new WebResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value()
                ,HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),e.getClass().getSimpleName());
    }

//    /**
//     * 参数校验异常处理
//     * @param e
//     * @param request
//     * @return
//     */
//    @ExceptionHandler({BindException.class, ConstraintViolationException.class, MethodArgumentNotValidException.class})
//    @ResponseBody
//    public WebResponse<Map> validateExceptionHandle(Exception e, HttpServletRequest request){
//        log.error("请求路径："+request.getRequestURI()+ StrUtil.COMMA + GlobalConstants.EXCEPTION_LOG_HEADER,e);
//
//        Map<String,String> errorInfos= MapUtil.newHashMap();
//        StringBuffer msg=new StringBuffer("参数校验异常").append(StrUtil.COLON);
//
//        if(e instanceof ConstraintViolationException){
//            for(ConstraintViolation cv:((ConstraintViolationException)e).getConstraintViolations()){
//                msg.append(cv.getMessage());
//                msg.append(StrUtil.COMMA);
//
//                cv.getPropertyPath().iterator().forEachRemaining(n->{
//                    errorInfos.put(n.getName(),cv.getMessage());
//                });
//            }
//        }else {
//            List<ObjectError> errors=null;
//            if(e instanceof BindException){
//                errors=((BindException)e).getAllErrors();
//            }else {
//                errors=((MethodArgumentNotValidException)e).getBindingResult().getAllErrors();
//            }
//
//            errors.stream().forEach(error->{
//                msg.append(error.getDefaultMessage()).append(StrUtil.COMMA);
//                if(error instanceof FieldError){
//                    errorInfos.put(((FieldError)error).getField(),error.getDefaultMessage());
//                }else {
//                    errorInfos.put(error.getObjectName(),error.getDefaultMessage());
//                }
//            });
//        }
//
//
//        return new WebResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),StrUtil.removeSuffix(msg.toString(),StrUtil.COMMA),errorInfos);
//    }
}
