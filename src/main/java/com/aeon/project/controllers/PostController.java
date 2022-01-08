package com.aeon.project.controllers;

import com.aeon.project.commons.PostPrincipal;
import com.aeon.project.entities.*;
import com.aeon.project.services.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class PostController {
	@Autowired
	private PostService postService;
	@GetMapping("/GetAllPost")
	public List<Post> GetPost() {
		List<Post> post = postService.GetAllPost();
        return post;
	}
	@GetMapping("/post")
	public List<Post> login(@RequestBody Post post) {
		List<Post> postAddress = postService.findPostAddress(post.getAddressName());
		return postAddress;
	}
	@PostMapping("/insert")
	public ResponseEntity<?> Insert(@RequestBody Post post) {
		postService.createPost(post);
        return new ResponseEntity<>("Insert Post successfully", HttpStatus.OK);
		
	}
	
	@PutMapping("/UpdatePostById")
	public ResponseEntity<?> Update(@RequestBody Post post) {
		
		postService.UpdatePostById(post.getId(), post);
        return new ResponseEntity<>("Update Post successfully", HttpStatus.OK);
		
	}
	@DeleteMapping("/DeletePostById")
		public ResponseEntity<?> Delete(@RequestBody Post post) {
		
		postService.deletePost(post.getId());
        return new ResponseEntity<>("Delete Post successfully", HttpStatus.OK);
		
	}
	
}
