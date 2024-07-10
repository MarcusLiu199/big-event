package com.mingkun.big_event.pojo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class User {

    @NotNull
    private Integer id; // 主键ID

    private String username; // 用户名

    @JsonIgnore // 让springMVC把当前对象转换成json字符串的时候忽略password，最终json字符串中就没有password这个属性
    private String password; // 密码

    @NotEmpty
    @Pattern(regexp = "^\\${1,10}$")
    private String nickname; // 昵称

    @NotEmpty
    @Email
    private String email; // 邮箱

    private String userPic; // 用户头像地址
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTIme; // 更新时间
}