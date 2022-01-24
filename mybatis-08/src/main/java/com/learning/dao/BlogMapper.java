package com.learning.dao;

import com.learning.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    int add(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map map);

    //查询博客2
    List<Blog> queryBlogChoose(Map map);

    //更新
    int updateBlog(Map map);

    //查询第1、2、3号记录的博客
    List<Blog> queryBlogForEach(Map map);

}
