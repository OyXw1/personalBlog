package com.oy.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oy.dao.BlogMapper;
import com.oy.entity.Blog;
import com.oy.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogMapper blogMapper;

	@Override
	public List<Blog> listBlog() {

		return blogMapper.listBlog();
	}

	@Override
	public List<Blog> findById(int blogid) {

		return blogMapper.findById(blogid);
	}

	@Override
	public void addBlog(Blog blog) {
		System.out.println(blog.getArticle());
		blogMapper.addBlog(blog);

	}

	@Override
	public void deleteBlog(int blogid) {
		blogMapper.deleteBlog(blogid);

	}

}
