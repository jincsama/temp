package com.sora.temp.dto;


import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
public class MessageDTO {
    //主键
    private Long id;

    //时间
    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime before;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime after;

    //正文
    private String text;

    //商铺id
    private Integer storeId;


    //分页
    private int page;

    private int pageSize;
}
