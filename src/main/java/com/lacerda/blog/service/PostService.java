package com.lacerda.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacerda.blog.model.Post;
import com.lacerda.blog.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> listAllPost() {
		return postRepository.findAll();
	}
}
