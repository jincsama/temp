package com.sora.temp.service;

import com.sora.temp.dto.LedgerDTO;
import com.sora.temp.result.PageResult;
import com.sora.temp.vo.LedgerVO;

public interface LedgerService {
    /**
     * 商品入库
     * @param commodityStoreDTO
     */
    void storage(LedgerDTO commodityStoreDTO);

    /**
     * 分页查询
     * @param ledgerDTO
     * @return
     */
    PageResult listLedger(LedgerDTO ledgerDTO);

    /**
     * 商品出库
     * @param ledgerDTO
     * @return
     */
    LedgerVO retrieval(LedgerDTO ledgerDTO);
}
