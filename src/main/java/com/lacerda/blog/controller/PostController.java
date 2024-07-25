package com.lacerda.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("blog")
public class PostController {

	@GetMapping("/listPosts")
	public String getListPosts() {
		return "Hello";
	}
}
