package com.newgen.service;

import java.util.List;

import com.newgen.bean.News;


public interface NewsService{

	
	void save(News mem);

	List<News> getAll();



}
