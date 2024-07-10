package com.mingkun.big_event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mingkun.big_event.pojo.Category;
import com.mingkun.big_event.pojo.Result;
import com.mingkun.big_event.pojo.Category.Add;
import com.mingkun.big_event.pojo.Category.Update;
import com.mingkun.big_event.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    @PostMapping
    // Assign Add.class value, which act as a label to the @Validated annotation
    // to group the validation annotation in category attributes.
    public Result add(@RequestBody @Validated(Add.class) Category category) {
        categoryService.add(category);
        return Result.success();
    }

    @GetMapping
    public Result<List<Category>> list() {
        List<Category> cs = categoryService.list();
        return Result.success(cs);
    }

    @GetMapping("/detail")
    public Result<Category> detail(Integer id) {
        Category c = categoryService.findById(id);
        return Result.success(c);
    }

    @PutMapping
    public Result update(@RequestBody @Validated(Update.class) Category category) {
        categoryService.update(category);
        return Result.success();
    }
}
