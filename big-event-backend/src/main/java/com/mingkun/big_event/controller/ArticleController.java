package com.mingkun.big_event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mingkun.big_event.pojo.Article;
import com.mingkun.big_event.pojo.Result;
import com.mingkun.big_event.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {
    
    @Autowired
    private ArticleService articleService;

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

    @PostMapping
    public Result add(@RequestBody Article article) {
        articleService.add(article);
        return Result.success();
    }
}
