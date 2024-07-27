package com.lacerda.blog.DTO;

import java.util.List;

import com.lacerda.blog.model.Post;

public record ResponseListPostsDTO(List<Post> list) {

}
