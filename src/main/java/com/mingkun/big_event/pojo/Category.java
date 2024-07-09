package com.mingkun.big_event.pojo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Category {
    private Integer Id; // 主键ID
    private String category; // 分类名称
    private String categoryAlias; // 分类别名
    private Integer createUser; // 创建人ID
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
