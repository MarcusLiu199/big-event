package com.mingkun.big_event.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.mingkun.big_event.pojo.Category;

@Mapper
public interface CategoryMapper {

    // 新增
    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time)" + 
            "values(#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    void add(Category category);


}
