package com.sora.temp.dto;


import lombok.Data;

@Data
public class CommodityStoreDTO {
    //主键
    private Long id;

    //商品id
    private Integer commodityId;

    //商铺id
    private Integer storeId;

    //数量
    private Long number;

    //分页
    private int page;

    private int pageSize;
}
