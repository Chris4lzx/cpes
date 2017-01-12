package com.atguigu.crowdfunding.cpes.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.atguigu.crowdfunding.cpes.bean.Role;
import com.atguigu.crowdfunding.cpes.bean.User;
import com.atguigu.crowdfunding.cpes.service.RoleService;
import com.atguigu.crowdfunding.cpes.service.UserService;
import com.atguigu.crowdfunding.util.Const;
import com.atguigu.crowdfunding.util.DateUtil;
import com.atguigu.crowdfunding.util.MD5Util;
import com.atguigu.crowdfunding.util.StringUtil;

@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {

	private Font mFont = new Font("Times New Roman", Font.BOLD, 24);
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	/**
	 * 跳转到用户主页面
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "user/index";
	}
	
	/**
	 * 跳转到用户新增页面
	 * @return
	 */
	@RequestMapping("/add")
	public String add() {
		return "user/add";
	}
	
	/**
	 * 跳转到用户修改页面
	 * @return
	 */
	@RequestMapping("/edit/{id}")
	public String edit( @PathVariable("id")Integer id, Model model ) {
		
		User user = userService.queryById(id);
		model.addAttribute("user", user);
		
		return "user/edit";
	}
	
	/**
	 * 跳转到用户角色分配页面
	 * @return
	 */
	@RequestMapping("/role/{id}")
	public String role( @PathVariable("id")Integer id, Model model ) {
		
		User user = userService.queryById(id);
		model.addAttribute("user", user);
		
		// 查询所有的角色数据
		List<Role> rs = roleService.queryAll();
		model.addAttribute("rs", rs);
		
		// 查询已经分配的角色数据
		List<Integer> ids = userService.queryUserRoleById(id);
		model.addAttribute("ars", ids);
		
		return "user/role";
	}
	
	/**
	 * 新增用户信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insert")
	public Object insert( User user ) {
		start();
		
		try {
			
			user.setCreatetime(DateUtil.getSystemtime());
			user.setUserpswd(MD5Util.digest("123123"));
			userService.insertUser(user);
			success(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			success(false);
		}
		
		return end();
	}
	
	/**
	 * 分配角色信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/assignRole")
	public Object assignRole( Integer id, Datas ds ) {
		start();
		
		try {
			userService.insertUserRole(id, ds);
			success(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			success(false);
		}
		
		return end();
	}
	
	/**
	 * 取消分配角色信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/unAssignRole")
	public Object unAssignRole( Integer id, Datas ds ) {
		start();
		
		try {
			userService.deleteUserRole(id, ds);
			success(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			success(false);
		}
		
		return end();
	}
	
	/**
	 * 新增用户信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/assignAll")
	public Object assignAll( Integer id ) {
		start();
		
		try {
			List<Role> rs = roleService.queryAll();
			userService.insertAllUserRole(id, rs);
			success(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			success(false);
		}
		
		return end();
	}
	
	/**
	 * 取消分配所有的角色信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/unAssignAll")
	public Object unAssignAll( Integer id ) {
		start();
		
		try {
			userService.deleteAllUserRole(id);
			success(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			success(false);
		}
		
		return end();
	}
	
	/**
	 * 修改用户信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Object update( User user ) {
		start();
		
		try {
			userService.updateUser(user);
			success(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			success(false);
		}
		
		return end();
	}
	
	/**
	 * 删除用户信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deletes")
	public Object deletes( Datas ds ) {
		start();
		
		try {
			userService.deleteUsers(ds);
			success(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			success(false);
		}
		
		return end();
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
		
		Page<User> userPage = userService.queryUserDatas(paramMap);
		userPage.setDraw(draw);
		return userPage;
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public Object login( User user, String authcode, HttpSession session ) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String sesscode = (String)session.getAttribute(Const.AUTHCODE);
		if (authcode == null || !authcode.equals(sesscode)) {
			resultMap.put("success", false);
			resultMap.put("error", "验证码不正确。请重新输入");
		} else {
			// 根据登录账号查询用户信息
			User dbUser = userService.queryUserByLoginacct(user.getLoginacct());
			if ( dbUser == null ) {
				resultMap.put("success", false);
				resultMap.put("error", "用户账号不存在。请重新输入");
			} else {
			    if ( dbUser.getUserpswd().equals(MD5Util.digest(user.getUserpswd())) ) {
			    	resultMap.put("success", true);
			    	session.setAttribute(Const.SESS_D_USER, dbUser);
			    } else {
			    	resultMap.put("success", false);
			    	resultMap.put("error", "用户账号/密码不正确。请重新输入");
			    }
			}
		}
		return resultMap;
	}
	
	/**
	 * 图形验证码
	 * @param response
	 * @param r1
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping("/verify")
	public void webverify( HttpServletResponse response, Integer r1, HttpSession session ) throws Exception {
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		
		response.setContentType("image/png");
		
		int width  = 100;
		int height = 40;
		
		// 画布
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		// 画笔
		Graphics g = image.getGraphics();
		
		String color = "#59B0FF";
		if ( StringUtil.isNotEmpty(color) ) {
			g.setColor(new Color(Integer.parseInt(color.substring(1, 3), 16),Integer.parseInt(color.substring(3, 5), 16),Integer.parseInt(color.substring(5, 7), 16)));	
		} else {
			g.setColor(new Color(50,118,177));
		}
		
		g.fillRect(1, 1, width-1, height-1);
		//66D178
		//g.setColor(new Color(204,204,204));
		g.setColor(new Color(77,170,255));
		g.drawRect(0, 0, width-1, height-1);
		g.setFont(mFont);
		g.setColor(new Color(255,255,255));
		
		String content = "";
		int i = r1;
		
		int i1 = new Random().nextInt(10);
		
		content = i + " + " + i1 + " = ? ";
		
		g.drawString(content, 10, 25);
		session.setAttribute(Const.AUTHCODE, ""+(i+i1));
		g.dispose();
		ImageIO.write(image, "PNG", response.getOutputStream());
	}
}
