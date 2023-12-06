package com.saymeevetime.business.entity;

import java.time.LocalTime;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 车次
 * </p>
 *
 * @author ChesterZhao
 * @since 2023-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Train对象", description="车次")
public class Train implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "车次编号")
    private String code;

    @ApiModelProperty(value = "车次类型|枚举[TrainTypeEnum]")
    private String type;

    @ApiModelProperty(value = "始发站")
    private String start;

    @ApiModelProperty(value = "始发站拼音")
    private String startPinyin;

    @ApiModelProperty(value = "出发时间")
    private LocalTime startTime;

    @ApiModelProperty(value = "终点站")
    private String end;

    @ApiModelProperty(value = "终点站拼音")
    private String endPinyin;

    @ApiModelProperty(value = "到站时间")
    private LocalTime endTime;

    @ApiModelProperty(value = "新增时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


}
