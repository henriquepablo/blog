package com.lacerda.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacerda.blog.DTO.ResponseCreatePostDTO;
import com.lacerda.blog.DTO.ResponseListPostsDTO;
import com.lacerda.blog.model.Post;
import com.lacerda.blog.service.PostService;

@RestController
@RequestMapping("blog")
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/listPosts")
	public ResponseEntity<ResponseListPostsDTO> ListPosts() {
		return ResponseEntity.ok(new ResponseListPostsDTO(postService.listAllPost()));
	}
	
	@PostMapping("/createPost")
	public ResponseEntity<ResponseCreatePostDTO> createPost(@RequestBody Post post) {
		
		return ResponseEntity.ok(new ResponseCreatePostDTO(postService.createPost(post)));
	}
}
