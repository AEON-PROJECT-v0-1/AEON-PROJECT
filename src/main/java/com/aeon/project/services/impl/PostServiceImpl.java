package com.aeon.project.services.impl;

import com.aeon.project.commons.PostPrincipal;
import com.aeon.project.entities.Post;
import com.aeon.project.entities.User;
import com.aeon.project.repositories.PostRepository;
import com.aeon.project.services.PostService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
    public Post createPost(Post post) {
        return postRepository.saveAndFlush(post);
    }
	@Override
	public PostPrincipal findPostAddress(String postNo) {
		Post post = postRepository.findByPostNo(postNo);
		PostPrincipal postPrincipal = new PostPrincipal();
		
		return postPrincipal;
	}
	
	@Override
    public List<Post> GetAllPost() {
        return postRepository.findAll();
    }
	@Override
    public List<Post> UpdatePostById(Iterable<Long> id) {
		List<Post> post = postRepository.findAllById(id);
        return postRepository.findAll();
    }
	
	
}
