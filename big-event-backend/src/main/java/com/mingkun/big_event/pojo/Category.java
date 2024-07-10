package com.mingkun.big_event.pojo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Category {
    @NotNull(groups = Update.class)
    private Integer Id; // 主键ID

    @NotEmpty(groups = {Add.class, Update.class})
    private String categoryName; // 分类名称

    @NotEmpty(groups = {Add.class, Update.class})
    private String categoryAlias; // 分类别名
    private Integer createUser; // 创建人ID

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime; // 创建时间
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime; // 更新时间

    public interface Add {
    
        
    }

    public interface Update {
    
        
    }
}
