package com.sora.temp.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommodityStoreVO {

    //商品id
    private Integer commodityId;

    //商铺id
    private Integer storeId;

    //数量
    private Long number;

}
