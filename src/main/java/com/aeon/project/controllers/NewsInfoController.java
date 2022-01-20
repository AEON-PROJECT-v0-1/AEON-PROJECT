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
import com.aeon.project.entities.NewsInfo;
import com.aeon.project.services.NewsInfoService;


@RestController
@RequestMapping("/api/newsInfo")
public class NewsInfoController {
	@Autowired
	private NewsInfoService newsInfoService;
	
	private Sort.Direction getSortDirection(String direction) {
	    if (direction.equals("asc")) {
	      return Sort.Direction.ASC;
	    } else if (direction.equals("desc")) {
	      return Sort.Direction.DESC;
	    }

	    return Sort.Direction.ASC;
  }
	
	@GetMapping("/getAll")
	public List<NewsInfo> GetAllNews()  throws SQLException{
		List<NewsInfo> newsInfo = newsInfoService.GetAllNews();
        return newsInfo;
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
		      List<NewsInfo> newsInfo = null;
				try {
					newsInfo = newsInfoService.GetAllNews();
				} catch (Exception e) {
					e.printStackTrace();
				}
				Page<NewsInfo> pageTuts = null;
		      if (newsInfo.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }else {
			      pageTuts =  newsInfoService.GetAllNews(Sort.by(orders), page, size, sort);
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
	public ResponseEntity<?> Insert(@RequestBody NewsInfo newsInfo) {
		newsInfoService.createNews(newsInfo);
        return new ResponseEntity<>("Insert Post successfully", HttpStatus.OK);
		
	}
	
	@GetMapping("/getNews")
	public List<NewsInfo> GetNews(@RequestBody NewsInfo newsInfo) {
		List<NewsInfo> listNews = newsInfoService.GetNews(newsInfo.getNewsNo());
        return listNews;
	}
	
	@PutMapping("/updateNews")
	public ResponseEntity<?> Update(@RequestBody NewsInfo newsInfo) {	
		newsInfoService.UpdateNewsById(newsInfo.getId(), newsInfo);
        return new ResponseEntity<>("Update Post successfully", HttpStatus.OK);
		
	}
		
	@DeleteMapping("/DeletePostById")
	public ResponseEntity<?> Delete(@RequestBody News news) {
		newsInfoService.deleteNews(news.getId());
		return new ResponseEntity<>("Delete Post successfully", HttpStatus.OK);
	}
	
}
