package com.newgen.controller;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newgen.bean.Mem;
import com.newgen.bean.PageView;
import com.newgen.service.MemService;
import com.newgen.utils.PageUtil;


@Controller
@RequestMapping("/index")
public class IndexContoller {
	
	@Autowired
	private MemService memService;

	
	

}
