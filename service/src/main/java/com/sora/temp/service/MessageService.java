package com.sora.temp.service;

import com.sora.temp.dto.LedgerDTO;
import com.sora.temp.dto.MessageDTO;
import com.sora.temp.vo.MessageVO;
import com.sora.temp.result.PageResult;

public interface MessageService {
    PageResult listMessage(MessageDTO messageDTO);

    void saveMessage(LedgerDTO ledgerDTO);

    MessageVO getById(Long id);
}
