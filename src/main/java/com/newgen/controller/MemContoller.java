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
@RequestMapping("/mem")
public class MemContoller {
	
	@Autowired
	private MemService memService;
	
	@RequestMapping("/getAll")
	public String getAll(Model model)
	{
		
		
	//List<Mem> list=memService.getAll();
	
	//model.addAttribute("mem", list);	
		
		List<Mem> all = memService.getAll();
		
		
		return "mem/list";
	}
	@RequestMapping("/getAllMems")
	@ResponseBody
	public JSONArray getAllMems(Model model)
	{
		JSONObject json =new JSONObject();
		
		
		List<Mem> list=memService.getAll();
		
		model.addAttribute("mem", list);
		
		json.put("data", list);
		
		//JSONObject fromObject = JSONObject.fromObject(list);
		
		JSONArray fromObject2 = JSONArray.fromObject(list);
		
		
		return fromObject2;
	}
	
	@RequestMapping("/add")
	public String add()
	{
		
		
		return "mem/addmem";
	}
	@RequestMapping("/save")
	public String save(Mem mem)
	{
		
		memService.save(mem);
		
		return "redirect:/mem/getAll.do";
	}
	@RequestMapping("/delete")
	public String delete(String id){
		
		memService.delete(id);
		
		return "redirect:/mem/getAll.do";
		
	}
	@RequestMapping("/updateUI")
	public String updateUI(String id,Model model){
		
		Mem mem =memService.getByID(id);
		
		model.addAttribute("mem", mem);	
		
		return "mem/updatemem";
	}
	@RequestMapping("/update")
	public String update(Mem mem){
		
		
		memService.update(mem);
		
		
		return "redirect:/mem/getAll.do";
	}
	@RequestMapping("/getPage")
	public String getPage(String pageNow,String pageSize,Mem mem,Model model){
		
		
	PageView<Mem> pageview=	memService.getPage(PageUtil.getPageView(pageNow, pageSize),mem);
	
	model.addAttribute("pageview",pageview);
		
	 return "mem/listpage";
	}
	
	

}
