package com.sora.temp.mapper;

import com.github.pagehelper.Page;
import com.sora.temp.annotation.AutoFill;
import com.sora.temp.dto.LedgerDTO;
import com.sora.temp.entity.Ledger;
import com.sora.temp.enumeration.OperationType;
import com.sora.temp.vo.LedgerVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LedgerMapper {
    /**
     * 添加入库记录
     * @param ledger
     */
    @AutoFill(OperationType.INSERT)
    @Insert("insert into temp.t_ledger(commodity_id, store_id, number, create_time) VALUES (#{commodityId}, #{storeId}, #{number}, #{createTime})")
    void saveLedgerlog(Ledger ledger);

    /**
     * 分页查询
     * @param ledgerDTO
     * @return
     */
    Page<LedgerVO> pageQuery(LedgerDTO ledgerDTO);
}
