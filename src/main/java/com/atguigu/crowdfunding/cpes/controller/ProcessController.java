package com.atguigu.crowdfunding.cpes.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowdfunding.bean.Page;
import com.atguigu.crowdfunding.controller.BaseController;

@Controller
@RequestMapping("/system/process")
public class ProcessController extends BaseController {
	
	@Autowired
	private RepositoryService repositoryService;
	
	/**
	 * 跳转到流程主页面
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "process/index";
	}
	
	/**
	 * 分页查询数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/datas")
	public Object datas( Integer draw, Integer start, @RequestParam(value="length")Integer pagesize ) {
		// 分页对象
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("start", start);
		paramMap.put("pagesize", pagesize);
		
		// 查询流程定义数据
		ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
		List<ProcessDefinition> pds = query.listPage(start, pagesize);
		List<Map<String, Object>> maplist = new ArrayList<Map<String, Object>>();
		int i = 1;
		for ( ProcessDefinition pd : pds ) {
			Map<String, Object> pdmap = new HashMap<String, Object>();
			pdmap.put("id", pd.getId());
			pdmap.put("index", i++);
			pdmap.put("name", pd.getName());
			pdmap.put("key", pd.getKey());
			pdmap.put("version", pd.getVersion());
			maplist.add(pdmap);
		}
		
		long size = query.count();
		
		Page<Map<String, Object>> page = new Page<Map<String, Object>>();
		
		page.setData(maplist);
		page.setRecordsTotal((int)size);
		page.setRecordsFiltered((int)size);
		
		page.setDraw(draw);
		return page;
	}
}
