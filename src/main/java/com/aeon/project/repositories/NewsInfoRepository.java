package com.aeon.project.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aeon.project.entities.News;
import com.aeon.project.entities.NewsInfo;
import com.aeon.project.entities.Post;

@Repository
public interface NewsInfoRepository extends BaseRepository<NewsInfo, Long>{
	List<NewsInfo> findByNewsInfo(String newsInfo);
	List<NewsInfo> findByNewsNo(String newsNo);
}
