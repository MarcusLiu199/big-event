package com.mingkun.big_event.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mingkun.big_event.pojo.Result;
import com.mingkun.big_event.utils.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/article")
public class ArticleController {
    
    @GetMapping("/list")
    public Result<String> list() {

        // // 验证token
        // try {
        //     Map<String, Object> claims = JwtUtil.parseToken(token);
            
        // } catch (Exception e) {
        //     // http 相应状态码为401
        //     response.setStatus(401);
        //     return Result.error("未登录");
        // }

        return Result.success("所有的文章数据");
    }
}
