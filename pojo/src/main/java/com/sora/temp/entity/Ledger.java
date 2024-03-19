package com.sora.temp.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Ledger {
    //主键
    private Long id;

    //商品id
    private Integer commodityId;

    //商铺id
    private Integer storeId;

    //数量
    private Long number;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
