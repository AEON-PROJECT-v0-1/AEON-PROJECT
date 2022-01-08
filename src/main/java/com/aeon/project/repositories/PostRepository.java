package com.aeon.project.repositories;

import com.aeon.project.entities.Post;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends BaseRepository<Post, Long> {
	  List<Post> findByAddressName(String addressName);
	  
	  
}
