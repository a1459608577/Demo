package base.factory;

import base.WebResponse;

/**
 * @Author ruanjiangke@mxftech.com
 * @Date 19-4-10 下午6:29
 * @Desc 响应结果构造工厂
 */
public class WebResponseBuilder {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> WebResponse success(T result){
        return new WebResponse(1,"SUCCESS",result);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static WebResponse success(){
        return new WebResponse(1,"SUCCESS",null);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> WebResponse success(String desc, T result){
        return new WebResponse(1,desc,result);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> WebResponse success(int status, T data){
        return new WebResponse(status,null,data);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static WebResponse fail(){
        return new WebResponse(-1,"FAIL",null);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> WebResponse fail(T result){
        return new WebResponse(-1,"FAIL",result);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static WebResponse fail(String desc){
        return new WebResponse(-1,desc,null);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> WebResponse fail(int status, String desc){
        return new WebResponse(status,desc,null);
    }
}
