package com.bluexiii.zenscaffold.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by bluexiii on 21/06/2017.
 */
@ApiModel("产品定义")
@Getter
@Setter
@ToString
public class ProductDTO {
    @ApiModelProperty(value = "产品编码")
    private Long productId;
    @ApiModelProperty(value = "产品名称")
    private String productName;
}
