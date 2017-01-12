package com.atguigu.crowdfunding.cpes.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.crowdfunding.cpes.bean.Permission;
import com.atguigu.crowdfunding.cpes.bean.User;
import com.atguigu.crowdfunding.cpes.service.UserService;
import com.atguigu.crowdfunding.util.GlobalNames;

@Controller
public class ForwordController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/system/toLogin")
	public String login(){
		return "login";
	}
	
	
	/**
	 * 跳转到用户主页面
	 * @return
	 */
	@RequestMapping("/system/main")
	public String main( HttpSession session, Model model ) {
		
		User loginUser = (User)session.getAttribute(GlobalNames.SESS_D_USER);
		
		// 查询登录用户已经分配的许可信息
		List<Permission> ps = userService.queryPermissions(loginUser);
		Permission root = null;
		Map<Integer, Permission> pMap = new HashMap<Integer, Permission>();
		for ( Permission p : ps ) {
			pMap.put(p.getId(), p);
		}
		
		for ( Permission childPermission : ps ) {
			Integer pid = childPermission.getPid();
			if ( pid == 0 ) {
				root = childPermission;
			} else {
				Permission parentPermission = pMap.get(pid);
				parentPermission.getChildren().add(childPermission);
			}
		}
		
		model.addAttribute("root", root);

		return "main";
	}
}
