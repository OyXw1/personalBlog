package com.oy.dao;

import java.util.List;

import com.oy.entity.Blog;

public interface BlogMapper {
	public List<Blog> listBlog();

	public List<Blog> findById(int blogid);

	public void addBlog(Blog blog);

	public void deleteBlog(int blogid);
}
