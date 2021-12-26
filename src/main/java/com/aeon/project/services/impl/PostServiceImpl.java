package com.aeon.project.services.impl;

import com.aeon.project.commons.PostPrincipal;
import com.aeon.project.entities.Post;
import com.aeon.project.repositories.PostRepository;
import com.aeon.project.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public PostPrincipal findPostAddress(String postNo) {
		Post post = postRepository.findByPostNo(postNo);
		PostPrincipal postPrincipal = new PostPrincipal();
		
		return postPrincipal;
	}
}
