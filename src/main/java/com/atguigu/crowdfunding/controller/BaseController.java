package com.atguigu.crowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

import com.atguigu.crowdfunding.util.GlobalNames;


public class BaseController {

	ThreadLocal<Map<String, Object>> results = new ThreadLocal<>();
	
	protected void start(){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		results.set(resultMap);
	}

	protected void success(boolean flag) {
		Map<String, Object> resultMap = results.get();
		resultMap.put(GlobalNames.SUCCESS, flag);
	}
	
	protected void error(String msg) {
		Map<String, Object> resultMap = results.get();
		resultMap.put(GlobalNames.ERROR, msg);
	}
	
	protected void param(String key, Object obj) {
		Map<String, Object> resultMap = results.get();
		resultMap.put(key, obj);
	}
	
	protected Object end(){
		return results.get();
	}
}
