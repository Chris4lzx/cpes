package com.atguigu.crowdfunding.cpes.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowdfunding.bean.Datas;
import com.atguigu.crowdfunding.bean.Page;
import com.atguigu.crowdfunding.controller.BaseController;
import com.atguigu.crowdfunding.cpes.bean.Permission;
import com.atguigu.crowdfunding.cpes.bean.Role;
import com.atguigu.crowdfunding.cpes.service.PermissionService;
import com.atguigu.crowdfunding.cpes.service.RoleService;
import com.atguigu.crowdfunding.util.GlobalMsg;
import com.atguigu.crowdfunding.util.GlobalNames;

@Controller
@RequestMapping("/system/role/")
public class RoleController extends BaseController{

	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping("assign")
	@ResponseBody
	public Object assign(Datas datas,Integer roleid){
		start();
		
		try {
			roleService.assign(datas,roleid);
			success(true);
		} catch (Exception e) {
			success(false);
			error(GlobalMsg.ROLE_ASSIGN_FAIL);
		}
		return end();
	}
	
	@RequestMapping("permission/{id}")
	public String toPermission(Model model,@PathVariable(value = "id")Integer id){
		Role roleById = roleService.getRoleById(id);
		model.addAttribute(GlobalNames.ROLE, roleById);
		return "role/permission";
	}
	
	/**
	 * 删除
	 * @param datas
	 * @return
	 */
	@RequestMapping("deletes")
	@ResponseBody
	public Object delete(Datas datas){
		start();
		try {
			roleService.delete(datas);
			success(true);
		} catch (Exception e) {
			e.printStackTrace();
			success(false);
			error(GlobalMsg.ROLE_DELETE_FAIL);
		}
		return end();
	}
	
	/**
	 * 添加role信息
	 * @param role
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public Object update(Role role){
		start();
		try {
			roleService.updateRole(role);
			success(true);
		} catch (Exception e) {
			e.printStackTrace();
			success(false);
			error(GlobalMsg.ROLE_UPDATE_FAIL);
		}
		
		return end();
	}
	
	
	/**
	 * 跳转到修改页面
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("edit/{id}")
	public String edit(Model model,@PathVariable("id")Integer id){
		Role role = roleService.getRoleById(id);
		model.addAttribute(GlobalNames.ROLE, role);
		return "role/edit";
	}
	
	/**
	 * 添加role信息
	 * @param role
	 * @return
	 */
	@RequestMapping("insert")
	@ResponseBody
	public Object insert(Role role){
		start();
		try {
			roleService.insertRole(role);
			success(true);
		} catch (Exception e) {
			e.printStackTrace();
			success(false);
			error(GlobalMsg.ROLE_INSERT_FAIL);
		}
		
		return end();
	}
	/**
	 * 转到添加页面
	 * @return
	 */
	@RequestMapping("add")
	public String toAdd(){
		return "role/add";
	}
	
	@RequestMapping("index")
	public String toIndex(){
		return "role/index";
	}
	
	@RequestMapping("datas")
	@ResponseBody
	public Object datas(Integer draw, Integer start,@RequestParam(value = "length")Integer pageSize ){
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("start", start);
		map.put("pageSize", pageSize);
		
		Page<Role> rolePage = roleService.queryRoleDatas(map);
		
		rolePage.setDraw(draw);
		
		return rolePage;
	}
	
	@RequestMapping("/permissiontree")
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
