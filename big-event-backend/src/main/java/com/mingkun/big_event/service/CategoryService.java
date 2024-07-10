package com.mingkun.big_event.service;

import java.util.List;

import com.mingkun.big_event.pojo.Category;

public interface CategoryService {

    // 新增
    public void add(Category category);

    // 列表查询
    public List<Category> list();

    // 根据id查询分类信息
    public Category findById(Integer id);

    // 更新分类
    public void update(Category category);

    // 删除分类
    public void delete(Integer id);
}