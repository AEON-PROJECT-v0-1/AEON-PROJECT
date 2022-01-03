package com.aeon.project.services;

import java.util.List;

import com.aeon.project.commons.PostPrincipal;
import com.aeon.project.entities.Post;


public interface PostService {
	PostPrincipal findPostAddress(String postNo);
	Post createPost(Post post);
	List<Post> GetAllPost();
	List<Post> UpdatePostById(Iterable<Long> id);


}
