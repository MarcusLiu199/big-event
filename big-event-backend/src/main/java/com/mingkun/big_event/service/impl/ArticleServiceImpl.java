package com.mingkun.big_event.service.impl;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mingkun.big_event.mapper.ArticleMapper;
import com.mingkun.big_event.pojo.Article;
import com.mingkun.big_event.service.ArticleService;
import com.mingkun.big_event.utils.ThreadLocalUtil;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        article.setCreateUser(userId);
        
        articleMapper.add(article);
    }
    
}
