package com.aeon.project.repositories;

import com.aeon.project.entities.Post;

import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends BaseRepository<Post, Long> {
	  Post findByPostNo(String postNo);
	  
}
