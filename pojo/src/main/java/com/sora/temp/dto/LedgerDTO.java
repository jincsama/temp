package com.sora.temp.dto;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class LedgerDTO {
    //主键
    private Long id;

    //商品id
    private Integer commodityId;

    //商品名称
    private String name;

    //商铺id
    private Integer storeId;

    //数量
    private Long number;

    //数量
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    //分页
    private int page;

    private int pageSize;
}
