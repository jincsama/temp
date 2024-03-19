package com.sora.temp.mapper;

import com.github.pagehelper.Page;
import com.sora.temp.annotation.AutoFill;
import com.sora.temp.dto.CommodityDTO;
import com.sora.temp.entity.Commodity;
import com.sora.temp.enumeration.OperationType;
import com.sora.temp.vo.CommodityStoreVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommodityMapper {

    /**
     * 新增商品
     *
     * @param commodity
     */
    @AutoFill(OperationType.INSERT)
    void saveCommodity(Commodity commodity);

    /**
     * 修改商品
     *
     * @param commodity
     * @return
     */
    @AutoFill(OperationType.UPDATE)
    void updateCommodity(Commodity commodity);

    /**
     * 批量删除
     *
     * @param ids
     */
    void removeCommodity(List<Long> ids);

    /**
     * 分页查询
     *
     * @param commodityDTO
     * @return
     */
    Page<CommodityStoreVO> pageQuery(CommodityDTO commodityDTO);

    @Select("select * from temp.t_commodity where id = #{id}")
    Commodity getById(Integer commodityId);
}
