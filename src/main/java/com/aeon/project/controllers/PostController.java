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
	@PostMapping("/post")
	public ResponseEntity<?> login(@RequestBody Post post) {
		PostPrincipal postAddress = postService.findPostAddress(post.getPostNo());
		return ResponseEntity.ok(postAddress);
	}
	@PostMapping("/insert")
	public ResponseEntity<?> Insert(@RequestBody Post post) {
		postService.createPost(post);
        return new ResponseEntity<>("Insert Post successfully", HttpStatus.OK);
		
	}
	@PutMapping("/UpdatePostById")
	public ResponseEntity<?> Update(Iterable<Long> id) {
		postService.UpdatePostById(id);
        return new ResponseEntity<>("Insert Post successfully", HttpStatus.OK);
		
	}
	
}
