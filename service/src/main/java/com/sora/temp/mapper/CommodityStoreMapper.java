package com.sora.temp.mapper;

import com.github.pagehelper.Page;
import com.sora.temp.dto.CommodityStoreDTO;
import com.sora.temp.dto.LedgerDTO;
import com.sora.temp.vo.LedgerVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommodityStoreMapper {
    /**
     * 插入中间表
     * @param ledgerDTO
     */
    @Insert("insert into temp.t_commodity_store(commodity_id, store_id, number) VALUES (#{commodityId}, #{storeId}, #{number})")
    void saveCommodityStore(LedgerDTO ledgerDTO);

    /**
     *更新中间表
     * @param ledgerDTO
     */
    void updateCommodityStore(CommodityStoreDTO ledgerDTO);

    /**
     * 查询中间表
     * @param commodityId
     * @param storeId
     * @return
     */

    @Select("select * from temp.t_commodity_store where commodity_id = #{commodityId} and store_id = #{storeId}")
    CommodityStoreDTO getByCommodityIdStoreId(Integer commodityId, Integer storeId);

}
