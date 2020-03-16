package com.cdc.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class GoodVo extends Good {

    @TableField("provinceName")
    private String provinceName;
    @TableField("cityName")
    private String cityName;
    @TableField("districtName")
    private String districtName;
    @TableField("sNames")
    private String sNames;

    private String sids;
    @TableField("zhNames")
    private String zhNames;

    private String asid;


}
