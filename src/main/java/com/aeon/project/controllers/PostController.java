package com.aeon.project.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aeon.project.entities.Post;
import com.aeon.project.services.PostService;

@RestController
@RequestMapping("/api/address")
public class PostController {
	@Autowired
	private PostService postService;
	
	  private Sort.Direction getSortDirection(String direction) {
		    if (direction.equals("asc")) {
		      return Sort.Direction.ASC;
		    } else if (direction.equals("desc")) {
		      return Sort.Direction.DESC;
		    }

		    return Sort.Direction.ASC;
	  }
	  
	@GetMapping("/GetAllPost")
	public ResponseEntity<?> GetPost(
		      @RequestParam(defaultValue = "0") int page,
		      @RequestParam(defaultValue = "4") int size,
		      @RequestParam(defaultValue = "id,desc") String[] sort) {
		
		 try {
		      List<Order> orders = new ArrayList<Order>();

		      if (sort[0].contains(",")) {
		        // will sort more than 2 fields
		        // sortOrder="field, direction"
		        for (String sortOrder : sort) {
		          String[] _sort = sortOrder.split(",");
		          orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
		        }
		      } else {
		        // sort=[field, direction]
		        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
		      }
		      List<Post> post = null;
				try {
					post = postService.GetAllPost();
				} catch (Exception e) {
					e.printStackTrace();
				}
				Page<Post> pageTuts = null;
		      if (post.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }else {
			      pageTuts = postService.GetAllPost(Sort.by(orders), page, size, sort);
			      if (pageTuts == null) {
			      Map<String, Object> response = new HashMap<>();
			      response.put("currentPage", pageTuts.getNumber());
			      response.put("totalItems", pageTuts.getTotalElements());
			      response.put("totalPages", pageTuts.getTotalPages());
			      }
		      
		      }
		      return new ResponseEntity<>(pageTuts, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	@GetMapping("/post")
	public List<Post> findPostAddress(@RequestBody Post post) {
		List<Post> postAddress = postService.findPostAddress(post.getAddressName());
		return postAddress;
	}
	@PostMapping("/insert")
	public ResponseEntity<?> Insert(@RequestBody Post post) {
		 try {
		      Post _post = postService.createPost(post);
		      return new ResponseEntity<>(_post, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		
		
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
