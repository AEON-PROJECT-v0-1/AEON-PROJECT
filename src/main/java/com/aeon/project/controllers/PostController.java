package com.aeon.project.controllers;

import com.aeon.project.commons.PostPrincipal;
import com.aeon.project.entities.*;
import com.aeon.project.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class PostController {
	@Autowired
	private PostService postService;

	@PostMapping("/post")
	public ResponseEntity<?> login(@RequestBody Post post) {
		PostPrincipal postAddress = postService.findPostAddress(post.getPostNo());
		return ResponseEntity.ok(postAddress);
	}
	
}
