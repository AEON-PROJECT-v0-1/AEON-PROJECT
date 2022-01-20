package com.aeon.project.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.aeon.project.entities.News;

public interface NewsService {
	News createNews(News news);
	List<News> GetAllNews() throws SQLException;
	News UpdateNewsById(long id, News news);
	List<News> GetNews(String newsNo);
	ResponseEntity<HttpStatus> deleteNews(long id);
	Page<News> GetAllNews(Sort by, int page, int size, String[] sort);
}
