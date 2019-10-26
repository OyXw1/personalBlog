package com.oy.service;

import java.util.List;

import com.oy.entity.Blog;

public interface BlogService {
	public List<Blog> listBlog();

	public List<Blog> findById(int blogid);

	public void addBlog(Blog blog);

	public void deleteBlog(int blogid);

}
