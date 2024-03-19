package com.sora.temp.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageVO {

    //主键
    private Long id;

    //时间
    private LocalDateTime createTime;

    //商铺id
    private Integer storeId;

    //正文
    private String text;

    //状态
    private int status;
}
