package com.oy.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oy.entity.Blog;
import com.oy.service.BlogService;

@Controller
public class BlogController {
	@Autowired
	private BlogService blogService;

	@RequestMapping("writeBlog")
	public String writeBlog(Blog blog) {
		Date currentTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String timeString = sdf.format(currentTime);
		blog.setTime(timeString);
		blogService.addBlog(blog);
		return "success";
	}

	@RequestMapping("selectAllBlog")
	public String selectAllBlog(HttpServletRequest request) throws Exception {
		try {
			List<Blog> blogs = blogService.listBlog();
			request.setAttribute("blogs", blogs);
			return "index";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return "index";
		}
	}

	@RequestMapping("selectAllBlog2")
	public String selectAllBlog2(HttpServletRequest request) {
		try {
			List<Blog> blogs = blogService.listBlog();
			System.out.println("title:" + blogs.get(0).getBlogtitle());
			request.setAttribute("blogs", blogs);
			return "admin";
		} catch (Exception e) {
			System.out.println(e);
			return "admin";
		}
	}

	@RequestMapping("selectBlogById")
	public String selectBlogById(HttpServletRequest request) throws Exception {
		try {
			String id = request.getParameter("blogid");
			int blogid = Integer.parseInt(id);
			List<Blog> blogs = blogService.findById(blogid);
			request.setAttribute("blog", blogs.get(0));
			return "blog";
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@RequestMapping("adminblog")
	public String adminblog(HttpServletRequest request) {
		try {
			List<Blog> blogs = blogService.listBlog();
			request.setAttribute("blogs", blogs);
			return "adminblog";
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@RequestMapping("deleteBlogById")
	public String deleteBlogById(HttpServletRequest request) {
		try {
			String idString = request.getParameter("blogid");
			int blogid = Integer.parseInt(idString);
			blogService.deleteBlog(blogid);
			return "redirect:adminblog";
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
