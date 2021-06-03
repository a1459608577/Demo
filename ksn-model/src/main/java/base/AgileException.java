package base;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

/**
 * 异常基类
 */
@Data
public class AgileException extends RuntimeException {

    private ExceptionStatus status;

    private String errMsg;

    public AgileException(){}

    public AgileException(String msg){
        super(msg);
    }

    public AgileException(Throwable e){
        super(e);
    }

    public AgileException(String message, Throwable ex) {
        super(message, ex);
    }

    public AgileException(ExceptionStatus status){
        this(status.toString());
        this.status= status;
        this.errMsg=status.toString();
    }

    public AgileException(String msgFormat, String...args){
        this(ExceptionStatus.INTERNAL_SERVER_ERROR);
        this.errMsg= StrUtil.format(msgFormat,args);
    }
}
