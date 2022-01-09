package com.aeon.project.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.aeon.project.entities.Post;


public interface PostService {
	List<Post> findPostAddress(String postNo);
	Post createPost(Post post);
	List<Post> GetAllPost();
	Post UpdatePostById(long id, Post post);
	ResponseEntity<HttpStatus> deletePost(long id);
	Page<Post> GetAllPost(Sort by, int page, int size, String[] sort);


}
