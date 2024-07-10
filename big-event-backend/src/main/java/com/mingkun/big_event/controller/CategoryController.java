package com.mingkun.big_event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mingkun.big_event.pojo.Category;
import com.mingkun.big_event.pojo.Result;
import com.mingkun.big_event.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    @PostMapping("/")
    public Result add(@RequestBody Category category) {
        categoryService.add(category);
        return Result.success();
    }
}
