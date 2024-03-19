package com.sora.temp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sora.temp.dto.CommodityStoreDTO;
import com.sora.temp.dto.LedgerDTO;
import com.sora.temp.entity.Commodity;
import com.sora.temp.entity.Ledger;
import com.sora.temp.exception.BaseException;
import com.sora.temp.mapper.CommodityMapper;
import com.sora.temp.mapper.CommodityStoreMapper;
import com.sora.temp.mapper.LedgerMapper;
import com.sora.temp.result.PageResult;
import com.sora.temp.service.LedgerService;
import com.sora.temp.vo.LedgerVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LedgerServiceImpl implements LedgerService {

    @Autowired
    private CommodityStoreMapper commodityStoreMapper;

    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private LedgerMapper ledgerMapper;


    /**
     * 商品入库
     *
     * @param ledgerDTO
     */
    @Override
    @Transactional
    public void storage(LedgerDTO ledgerDTO) {
        //商品是否存在
        Commodity commodity = commodityMapper.getById(ledgerDTO.getCommodityId());
        if (commodity == null) {
            throw new BaseException("商品不存在");
        }
        //插入日志
        Ledger ledger = new Ledger();
        BeanUtils.copyProperties(ledgerDTO, ledger);
        ledgerMapper.saveLedgerlog(ledger);
        //更新商品总量
        commodity.setNumber(commodity.getNumber() + ledgerDTO.getNumber());
        //中间表是否存在
        CommodityStoreDTO commodityStore = commodityStoreMapper.getByCommodityIdStoreId(ledgerDTO.getCommodityId(), ledgerDTO.getStoreId());
        if (commodityStore == null) {
            commodityStoreMapper.saveCommodityStore(ledgerDTO);
        } else {
            ledgerDTO.setNumber(ledgerDTO.getNumber() + commodityStore.getNumber());
            commodityStore.setNumber(commodityStore.getNumber() + ledger.getNumber());
            commodityStoreMapper.updateCommodityStore(commodityStore);
        }
        commodityMapper.updateCommodity(commodity);
    }

    /**
     * 分页查询
     * @param ledgerDTO
     * @return
     */
    @Override
    public PageResult listLedger(LedgerDTO ledgerDTO) {
        PageHelper.startPage(ledgerDTO.getPage(), ledgerDTO.getPageSize());
        Page<LedgerVO> page = ledgerMapper.pageQuery(ledgerDTO);

        return new PageResult(ledgerDTO.getPage(), ledgerDTO.getPageSize(), page.getTotal(), page.getResult());
    }

    /**
     * 商品出库
     * @param ledgerDTO
     * @return
     */
    @Override
    @Transactional
    public LedgerVO retrieval(LedgerDTO ledgerDTO) {
        //插入日志
        Ledger ledger = new Ledger();
        BeanUtils.copyProperties(ledgerDTO, ledger);
        ledger.setNumber(-ledger.getNumber());
        ledgerMapper.saveLedgerlog(ledger);
        //库存数量
        CommodityStoreDTO commodityStore = commodityStoreMapper.getByCommodityIdStoreId(ledgerDTO.getCommodityId(), ledgerDTO.getStoreId());
        if (commodityStore.getNumber() >= ledgerDTO.getNumber()) {
            commodityStore.setNumber(commodityStore.getNumber() - ledgerDTO.getNumber());
            commodityStoreMapper.updateCommodityStore(commodityStore);
            Commodity build = Commodity.builder().id(commodityStore.getCommodityId()).number(commodityStore.getNumber() - ledgerDTO.getNumber()).build();
            commodityMapper.updateCommodity(build);
        }else {
            throw new BaseException("库存不足");
        }
        LedgerVO ledgerVO = new LedgerVO();
        BeanUtils.copyProperties(commodityStore, ledgerVO);
        return ledgerVO;
    }
}
