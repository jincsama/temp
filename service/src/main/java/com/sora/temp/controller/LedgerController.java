package com.sora.temp.controller;

import com.sora.temp.dto.LedgerDTO;
import com.sora.temp.result.PageResult;
import com.sora.temp.result.Result;
import com.sora.temp.service.LedgerService;
import com.sora.temp.service.MessageService;
import com.sora.temp.vo.LedgerVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ledger")
@Api(tags = "台账相关接口")
public class LedgerController {

    @Autowired
    private LedgerService ledgerService;

    @Autowired
    private MessageService messageService;
    /**
     * 商品出库
     *
     * @param ledgerDTO
     * @return
     */
    @PutMapping("/out")
    @ApiOperation("出库接口")
    public Result<LedgerVO> retrieval(@RequestBody LedgerDTO ledgerDTO) {
        LedgerVO ledgerVO = ledgerService.retrieval(ledgerDTO);
        messageService.saveMessage(ledgerDTO);

        return Result.success(ledgerVO);
    }

    /**
     * 商品入库
     *
     * @param ledgerDTO
     * @return
     */
    @PostMapping("/in")
    @ApiOperation("入库接口")
    public Result storage(@RequestBody LedgerDTO ledgerDTO) {
        ledgerService.storage(ledgerDTO);

        return Result.success();
    }

    /**
     * 分页查询
     *
     * @param ledgerDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分页查询入库流水接口")
    public Result listLedger(LedgerDTO ledgerDTO) {
        PageResult pageResult = ledgerService.listLedger(ledgerDTO);

        return Result.success(pageResult);
    }
}


