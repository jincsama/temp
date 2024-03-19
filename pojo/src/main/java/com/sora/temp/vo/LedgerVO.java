package com.sora.temp.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LedgerVO {

    //商品名称
    private String name;

    //规格
    private Integer commodityId;

    //价格
    private Long totalPrice;

    //总量
    private Integer number;
}
