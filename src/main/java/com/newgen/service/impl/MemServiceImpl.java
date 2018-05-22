package com.newgen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nettyrpc.server.RpcService;
import com.nettyrpc.test.client.HelloService;
import com.newgen.bean.Mem;
import com.newgen.bean.PageView;
import com.newgen.mapper.MemMapper;
import com.newgen.service.MemService;

@Service
@RpcService(MemService.class)
public class MemServiceImpl implements MemService{
	
	@Autowired
	MemMapper mapper;

	@Override
	public void update(Mem mem) {
		
		try {
			mapper.update(mem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public PageView<Mem> getPage(PageView pageView, Mem mem) {
		
		
		
		
		return null;
	}

	@Override
	public Mem getByID(String id) {
			
		return mapper.getById(id);
	}

	@Override
	public void delete(String id) {
		try {
			mapper.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void save(Mem mem) {
		try {
			mapper.add(mem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Mem> getAll() {
		
		List<Mem> queryAll = mapper.queryAll(null);
		return queryAll;
	}





}
