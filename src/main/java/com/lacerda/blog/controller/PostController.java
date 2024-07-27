package com.lacerda.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacerda.blog.model.Post;
import com.lacerda.blog.service.PostService;

@RestController
@RequestMapping("blog")
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/listPosts")
	public List<Post> ListPosts() {
		return postService.listAllPost();
	}
}
