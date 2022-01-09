package com.aeon.project.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.aeon.project.entities.Post;
import com.aeon.project.repositories.PostRepository;
import com.aeon.project.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
    public Post createPost(Post post) {
        return postRepository.saveAndFlush(post);
    }
	
	@Override
	public List<Post> findPostAddress(@PathVariable("addressName") String addressName) {
		List<Post> postPrincipal = postRepository.findByAddressName(addressName);
		return postPrincipal;
	}
	
	@Override
    public List<Post> GetAllPost() {
        return postRepository.findAll();
    }
	
	@Override
    public Post UpdatePostById(@PathVariable("Id") long id, @RequestBody Post post) {
		Optional<Post> postData = postRepository.findById(id);
		if (postData.isPresent()) {
			Post _post = postData.get();
			_post.setPostNo(post.getPostNo());
			_post.setAddressName(post.getAddressName());
			_post.setCityName(post.getCityName());
			_post.setStreetName(post.getStreetName());
			return postRepository.save(post);
		}else {
			return null;
		}
    }
	
	@Override
	
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
	    try {
	      postRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@Override
	public Page<Post> GetAllPost(Sort by, @RequestParam(defaultValue = "0") int page,
		      @RequestParam(defaultValue = "4") int size,
		      @RequestParam(defaultValue = "id,desc") String[] sort ) {
		// TODO Auto-generated method stub
	      List<Order> orders = new ArrayList<Order>();
	      
	      Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

		return postRepository.findAll(pagingSort);
	}

	
}
