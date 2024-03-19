package com.sora.temp.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 封装分页查询结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult implements Serializable {

    private int current; //当前页

    private int size; //每页数据量

    private long total; //总记录数

    private List records; //当前页数据集合

}
