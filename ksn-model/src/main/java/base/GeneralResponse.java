package base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("接口响应结果基类")
public class GeneralResponse implements Serializable {

    @ApiModelProperty("业务处理状态")
    private Integer handleStatus;
    @ApiModelProperty("业务处理描述")
    private String handleDesc;

    public GeneralResponse(){}

    public GeneralResponse setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
        return this;
    }

    public GeneralResponse setHandleDesc(String handleDesc) {
        this.handleDesc = handleDesc;
        return this;
    }

    public GeneralResponse(int handleStatus, String handleDesc){
        this.handleDesc=handleDesc;
        this.handleStatus=handleStatus;
    }

}
