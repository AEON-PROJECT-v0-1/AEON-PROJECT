package com.aeon.project.services.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
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

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.aeon.project.entities.News;
import com.aeon.project.repositories.NewsRepository;
import com.aeon.project.services.NewsService;
import org.springframework.jdbc.core.RowMapper;

@Service
public class NewsServiceimpl implements NewsService, RowMapper<News>{

	@Autowired
	private NewsRepository newsRepository;
	
	@Override
    public News createNews(News news) {
        return newsRepository.saveAndFlush(news);
    }
	
	@Override
    public List<News> GetAllNews() throws SQLException{
        return newsRepository.findAll();
    }

	@Override
    public News UpdateNewsById(@PathVariable("Id") long id, @RequestBody News news) {
		Optional<News> newsData = newsRepository.findById(id);
		if (newsData.isPresent()) {
			News _news = newsData.get();
			_news.setNewsNo(news.getNewsNo());
			_news.setNewsName(news.getNewsName());
			_news.setTypeNews(news.getTypeNews());
			return newsRepository.save(news);
		}else {
			return null;
		}
    }
	
	
	
	@Override
    public List<News> GetNews(String newsNo) {
        return newsRepository.findByNewsNo(newsNo);
    }
	
	@Override
	  public ResponseEntity<HttpStatus> deleteNews(@PathVariable("id") long id) {
	    try {
	      newsRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@Override
	public Page<News> GetAllNews(Sort by, @RequestParam(defaultValue = "0") int page,
		      @RequestParam(defaultValue = "6") int size,
		      @RequestParam(defaultValue = "id,desc") String[] sort ) {
		// TODO Auto-generated method stub
	      List<Order> orders = new ArrayList<Order>();
	      
	      Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

		return newsRepository.findAll(pagingSort);
	}

	@Override
	public News mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
