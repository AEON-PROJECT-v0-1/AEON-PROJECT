package com.aeon.project.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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


import com.aeon.project.entities.News;
import com.aeon.project.services.NewsService;

@RestController
@RequestMapping("/api/news")
public class NewsController {
	@Autowired
	private NewsService newsService;
	
	private Sort.Direction getSortDirection(String direction) {
	    if (direction.equals("asc")) {
	      return Sort.Direction.ASC;
	    } else if (direction.equals("desc")) {
	      return Sort.Direction.DESC;
	    }

	    return Sort.Direction.ASC;
  }
	
	@GetMapping("/getAll")
	public List<News> GetAllNews()  throws SQLException{
		List<News> news = newsService.GetAllNews();
        return news;
	}

	@GetMapping("/getAllNews")
	public ResponseEntity<?> GetPost(
		      @RequestParam(defaultValue = "0") int page,
		      @RequestParam(defaultValue = "6") int size,
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
		      List<News> news = null;
				try {
					news = newsService.GetAllNews();
				} catch (Exception e) {
					e.printStackTrace();
				}
				Page<News> pageTuts = null;
		      if (news.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }else {
			      pageTuts =  newsService.GetAllNews(Sort.by(orders), page, size, sort);
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
	
	@PostMapping("/insert")
	public ResponseEntity<?> Insert(@RequestBody News news) {
		newsService.createNews(news);
        return new ResponseEntity<>("Insert Post successfully", HttpStatus.OK);
		
	}
	
	@GetMapping("/getNews")
	public List<News> GetNews(@RequestBody News news) {
		List<News> listNews = newsService.GetNews(news.getNewsNo());
        return listNews;
	}
	
	@PutMapping("/updateNews")
	public ResponseEntity<?> Update(@RequestBody News news) {	
		newsService.UpdateNewsById(news.getId(), news);
        return new ResponseEntity<>("Update Post successfully", HttpStatus.OK);
		
	}
		
	@DeleteMapping("/DeletePostById")
	public ResponseEntity<?> Delete(@RequestBody News news) {
		newsService.deleteNews(news.getId());
		return new ResponseEntity<>("Delete Post successfully", HttpStatus.OK);
	}
	
}
