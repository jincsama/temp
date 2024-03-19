package com.sora.temp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sora.temp.dto.LedgerDTO;
import com.sora.temp.dto.MessageDTO;
import com.sora.temp.vo.MessageVO;
import com.sora.temp.exception.BaseException;
import com.sora.temp.mapper.MessageMapper;
import com.sora.temp.result.PageResult;
import com.sora.temp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    /**
     * 分页查询消息
     *
     * @param messageDTO
     * @return
     */
    public PageResult listMessage(MessageDTO messageDTO) {
        PageHelper.startPage(messageDTO.getPage(), messageDTO.getPageSize());
        Page<MessageVO> page = messageMapper.pageQuery(messageDTO);

        return new PageResult(messageDTO.getPage(), messageDTO.getPageSize(), page.getTotal(), page.getResult());
    }

    /**
     * 生成消息
     *
     * @param ledgerDTO
     * @return
     */
    public void saveMessage(LedgerDTO ledgerDTO) {
        //TODO 具体消息
        MessageDTO messageDTO = MessageDTO.builder().storeId(ledgerDTO.getStoreId()).text("xxx仓库出库了xxx个xxx").build();
        Long id = messageMapper.saveMessage(messageDTO);

        smsAlerts(id);
    }

    /**
     * 定时短信
     * @param id
     */
    private void smsAlerts(Long id) {
        Date currentTime = new Date();
        long waitTime = currentTime.getTime() + (3 * 60 * 60 * 1000); // 三小时的毫秒数
        //long waitTime = currentTime.getTime() + (3 * 1000);

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                MessageVO messageVO = messageMapper.getById(id);
                if (messageVO != null) {
                    // TODO 短信
                    System.out.println(messageVO.getText());
                    messageMapper.updateStatus(id, 0);
                }
            }
        };
        timer.schedule(task, new Date(waitTime));
    }

    /**
     * 根据id查询消息详情
     *
     * @param id
     * @return
     */
    public MessageVO getById(Long id) {
        MessageVO messageVO = messageMapper.getById(id);
        if (messageVO == null) {
            throw new BaseException("消息不存在");
        }
        //TODO 枚举
        messageMapper.updateStatus(id, 0);

        return messageVO;
    }
}
