package com.newgen.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nettyrpc.server.RpcService;
import com.newgen.bean.News;
import com.newgen.service.NewsService;

@Service
@RpcService(NewsService.class)
public class NewsServiceImpl implements NewsService{

	@Override
	public void save(News mem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<News> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
