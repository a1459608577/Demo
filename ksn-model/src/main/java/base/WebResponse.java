package base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("同步任务接口响应结果")
public class WebResponse<T> extends GeneralResponse {

    @ApiModelProperty("业务处理结果")
    private T result;

    public WebResponse setResult(T result) {
        this.result = result;
        return this;
    }

    public WebResponse(){}

    public WebResponse(int handleStatus, String handleDesc, T result){
        super(handleStatus,handleDesc);
        this.result=result;
    }

}
