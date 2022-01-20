package com.aeon.project.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.aeon.project.entities.NewsInfo;

public interface NewsInfoService {
	NewsInfo createNews(NewsInfo newsInfo);
	List<NewsInfo> GetAllNews() throws SQLException;
	NewsInfo UpdateNewsById(long id, NewsInfo newsInfo);
	List<NewsInfo> GetNews(String newsNo);
	ResponseEntity<HttpStatus> deleteNews(long id);
	Page<NewsInfo> GetAllNews(Sort by, int page, int size, String[] sort);
}
