package com.newgen.service;

import java.util.List;

import com.newgen.bean.Mem;
import com.newgen.bean.PageView;


public interface MemService{

	void update(Mem mem);

	PageView<Mem> getPage(PageView pageView, Mem mem);

	Mem getByID(String id);

	void delete(String id);

	void save(Mem mem);

	List<Mem> getAll();



}
