package com.aeon.project.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aeon.project.entities.News;
import com.aeon.project.entities.Post;

@Repository
public interface NewsRepository extends BaseRepository<News, Long>{
	List<News> findByNewsNo(String newsNo);
	List<News> findByNewsName(String newsName);
	List<News> findByTypeNews(String typeNews);
}