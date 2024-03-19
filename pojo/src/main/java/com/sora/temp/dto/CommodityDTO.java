package com.sora.temp.dto;


import lombok.Data;

@Data
public class CommodityDTO {
    //主键
    private Long id;

    //规格
    private Integer spec;

    //商品名称
    private String name;

    //价格
    private Long price;

    //商品状态
    private Integer status;

    //分页
    private int page;

    private int pageSize;
}
