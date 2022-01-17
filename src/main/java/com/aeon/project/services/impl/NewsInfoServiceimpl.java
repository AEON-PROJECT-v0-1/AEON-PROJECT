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


import com.aeon.project.entities.NewsInfo;
import com.aeon.project.repositories.NewsInfoRepository;
import com.aeon.project.services.NewsInfoService;


@Service
public class NewsInfoServiceimpl implements NewsInfoService{

	@Autowired
	private NewsInfoRepository newsInfoRepository;
	
	@Override
    public NewsInfo createNews(NewsInfo newsInfo) {
        return newsInfoRepository.saveAndFlush(newsInfo);
    }
	
	@Override
    public List<NewsInfo> GetAllNews() throws SQLException{
        return newsInfoRepository.findAll();
    }

	@Override
    public NewsInfo UpdateNewsById(@PathVariable("Id") long id, @RequestBody NewsInfo newsinfo) {
		Optional<NewsInfo> newsData = newsInfoRepository.findById(id);
		if (newsData.isPresent()) {
			NewsInfo _news = newsData.get();
			_news.setNewsNo(newsinfo.getNewsNo());
			_news.setNewsInfo(newsinfo.getNewsInfo());
			return newsInfoRepository.save(newsinfo);
		}else {
			return null;
		}
    }
	
	
	
	@Override
    public List<NewsInfo> GetNews(String newsNo) {
        return newsInfoRepository.findByNewsNo(newsNo);
    }
	
	@Override
	  public ResponseEntity<HttpStatus> deleteNews(@PathVariable("id") long id) {
	    try {
	    	newsInfoRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@Override
	public Page<NewsInfo> GetAllNews(Sort by, @RequestParam(defaultValue = "0") int page,
		      @RequestParam(defaultValue = "6") int size,
		      @RequestParam(defaultValue = "id,desc") String[] sort ) {
		// TODO Auto-generated method stub
	      List<Order> orders = new ArrayList<Order>();
	      
	      Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

		return newsInfoRepository.findAll(pagingSort);
	}

}
