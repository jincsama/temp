package com.sora.temp.controller;


import com.sora.temp.dto.CommodityDTO;
import com.sora.temp.result.PageResult;
import com.sora.temp.result.Result;
import com.sora.temp.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/commodity")
@Api(tags = "商品相关接口")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    /**
     * 新增商品
     * @return
     */
    @PostMapping
    @ApiOperation("新增商品接口")
    public Result saveCommodity(@RequestBody CommodityDTO commodityDTO){
        commodityService.saveCommodity(commodityDTO);

        return Result.success();
    }

    /**
     * 修改商品
     * @param commodityDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改商品接口")
    public Result updateCommodity(@RequestBody CommodityDTO commodityDTO){
        commodityService.updateCommodity(commodityDTO);

        return Result.success();
    }

    /**
     * 批量删除商品
     * @return
     */
    @DeleteMapping
    @ApiOperation("批量删除商品接口")
    public Result removeCommodity(@RequestParam List<Long> ids){
        commodityService.removeCommodity(ids);

        return Result.success();
    }

    /**
     * 分页查询
     * @param commodityDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分页查询商品接口")
    public Result listCommodity(CommodityDTO commodityDTO){
        PageResult pageResult = commodityService.listCommodity(commodityDTO);

        return Result.success(pageResult);
    }
}
