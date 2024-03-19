package com.sora.temp.service;


import com.sora.temp.dto.CommodityDTO;
import com.sora.temp.result.PageResult;

import java.util.List;

public interface CommodityService {

    /**
     * 新增商品
     * @param commodityDTO
     */
    void saveCommodity(CommodityDTO commodityDTO);

    /**
     * 修改商品
     *
     * @param commodityDTO
     */
    void updateCommodity(CommodityDTO commodityDTO);

    /**
     * 分页查询
     * @param commodityDTO
     * @return
     */
    PageResult listCommodity(CommodityDTO commodityDTO);

    /**
     * 批量删除
     * @param ids
     */
    void removeCommodity(List<Long> ids);
}
