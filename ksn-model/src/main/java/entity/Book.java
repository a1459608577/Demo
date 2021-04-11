package entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/3/15 15:17
 */
@Data
@ApiModel("书籍对象")
public class Book {

    @ApiModelProperty("主键")
    @TableId("ID")
    private String id;
    @ApiModelProperty("书名")
    @TableField("BOOK_NAME")
    private String bookName;
    @ApiModelProperty("作者")
    @TableField("AUTHER")
    private String auther;
    @ApiModelProperty("价格")
    @TableField("PRICE")
    private String price;
    @ApiModelProperty("出版社")
    @TableField("PRESS")
    private String press;
}
