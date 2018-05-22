package com.newgen.utils;

import com.newgen.bean.PageView;





public class PageUtil {

	
	
	public static PageView getPageView(String pageNow,String pageSize) {
		
		PageView pageView = null;

		if (pageNow==null||pageNow.equals("")) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		if (pageSize==null||pageSize=="") {
			pageSize = "10";
		} 
		pageView.setPageSize(Integer.parseInt(pageSize));
		return pageView;
	}
}
