package com.sora.temp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Commodity {

    //主键
    private Integer id;

    //规格
    private Integer spec;

    //商品名称
    private String name;

    //价格
    private Integer price;

    //数量
    private Long number;

    //地址id
    private Integer storeId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
