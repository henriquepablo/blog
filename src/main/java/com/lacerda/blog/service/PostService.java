package com.lacerda.blog.service;

import java.util.List;
import java.util.Optional;

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

	public Post createPost(Post post) {
		return postRepository.save(post);
	}
	
	public Post editPost(Post post, Integer id) {
		
		Post entity = postRepository.findById(id).orElseThrow(() -> new RuntimeException("post not found"));
		
		entity.setTitle(post.getTitle());
		entity.setContent(post.getContent());
		
		return postRepository.save(entity);
		
	}
	
	public void deletePost(Integer id) {
		
		Post entity = postRepository.findById(id).orElseThrow(() -> new RuntimeException("post not found"));
		
		postRepository.delete(entity);
	}
}
