package com.sora.temp.controller;


import com.sora.temp.dto.MessageDTO;
import com.sora.temp.vo.MessageVO;
import com.sora.temp.result.PageResult;
import com.sora.temp.result.Result;
import com.sora.temp.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@Api(tags = "消息相关接口")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/page")
    @ApiOperation("分页查询消息接口")
    public Result listMessage(MessageDTO messageDTO){
        PageResult pageResult = messageService.listMessage(messageDTO);

        return Result.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation("消息详情接口")
    public Result getParticulars(@PathVariable Long id ){
        MessageVO messageVO = messageService.getById(id);

        return Result.success(messageVO);
    }
}
