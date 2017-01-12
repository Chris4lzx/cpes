package com.atguigu.crowdfunding.cpes.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowdfunding.controller.BaseController;
import com.atguigu.crowdfunding.cpes.bean.Permission;
import com.atguigu.crowdfunding.cpes.service.PermissionService;
import com.atguigu.crowdfunding.util.GlobalMsg;
import com.atguigu.crowdfunding.util.GlobalNames;

@Controller
@RequestMapping("/system/permission")
public class PermissionController extends BaseController{

	@Autowired
	private PermissionService permissionService;

	

	@RequestMapping("/index")
	public String toPermissionIndex(){
		return "permission/index";
	}
	@RequestMapping("/update")
	@ResponseBody
	public Object update(Permission permission){
		
		start();
		
		try {
			permissionService.update(permission);
			success(true);
		} catch (Exception e) {
			e.printStackTrace();
			success(false);
			error(GlobalMsg.PERMISSION_UPDATE_FAIL);
		}
		return end();
	}
	
	@RequestMapping("/edit")
	public String toEdit(Integer id , Model model){
		
		Permission permission = permissionService.getPermissionById(id);
		
		model.addAttribute("p", permission);
		
		return "permission/edit";
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(Integer id){
		
		start();
		try {
			permissionService.delete(id);
			success(true);
		} catch (Exception e) {
			e.printStackTrace();
			success(false);
			error(GlobalMsg.PERMISSION_DELETE_FAIL);
		}
		
		return end();
	
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Permission permission){
		start();
		try {
			permissionService.insert(permission);
			success(true);
		} catch (Exception e) {
			e.printStackTrace();
			success(false);
			error(GlobalMsg.PERMISSION_INSERT_FAIL);
		}
		return end();
	}
	
	
	/**
	 * 跳转到许可增加页面
	 * @param pid
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String toAdd(Integer pid,Model model){
		model.addAttribute(GlobalNames.PID,pid);
		return "permission/add";
	}
	
	@RequestMapping("/tree")
	@ResponseBody
	public Object tree(){
		List<Permission> permissions = new ArrayList<>();
		
		List<Permission> ps = permissionService.getAll();
		
		Map<Integer, Permission> map = new HashMap<Integer, Permission>();
		
		for (Permission p : ps) {
			map.put(p.getId(), p);
		}
		
		
		for (Permission p : ps) {
			Permission childPermission = p;
			Integer pid = p.getPid();
			
			Permission parentPermission = map.get(pid);
			
			if (parentPermission == null) {
				permissions.add(p);
			}else{
				parentPermission.getChildren().add(childPermission);
			}
			
		}
		
		
		return permissions;
	}
	
	
}
