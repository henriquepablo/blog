package com.lacerda.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lacerda.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
