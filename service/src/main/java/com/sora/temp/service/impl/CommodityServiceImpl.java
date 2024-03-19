package com.sora.temp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sora.temp.entity.Commodity;
import com.sora.temp.mapper.CommodityMapper;
import com.sora.temp.dto.CommodityDTO;
import com.sora.temp.vo.CommodityStoreVO;
import com.sora.temp.vo.LedgerVO;
import com.sora.temp.result.PageResult;
import com.sora.temp.service.CommodityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    /**
     * 新增商品
     * @param commodityDTO
     */
    @Override
    public void saveCommodity(CommodityDTO commodityDTO) {
        Commodity commodity = new Commodity();
        BeanUtils.copyProperties(commodityDTO, commodity);
        commodityMapper.saveCommodity(commodity);
    }

    /**
     * 修改商品
     *
     * @param commodityDTO
     */
    @Override
    public void updateCommodity(CommodityDTO commodityDTO) {
        Commodity commodity = new Commodity();
        BeanUtils.copyProperties(commodityDTO, commodity);
        commodityMapper.updateCommodity(commodity);


    }

    /**
     * 分页查询
     *
     * @param commodityDTO
     * @return
     */
    @Override
    public PageResult listCommodity(CommodityDTO commodityDTO) {
        PageHelper.startPage(commodityDTO.getPage(), commodityDTO.getPageSize());
        Page<CommodityStoreVO> page = commodityMapper.pageQuery(commodityDTO);

        return new PageResult(commodityDTO.getPage(), commodityDTO.getPageSize(), page.getTotal(), page.getResult());
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void removeCommodity(List<Long> ids) {
        commodityMapper.removeCommodity(ids);

    }
}
