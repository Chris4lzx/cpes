package com.atguigu.crowdfunding.cpes.controller;

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
import com.atguigu.crowdfunding.cpes.bean.AccCertimg;
import com.atguigu.crowdfunding.cpes.bean.CertImg;
import com.atguigu.crowdfunding.cpes.service.CertimgService;

@Controller
@RequestMapping("/system/cert")
public class CertImgController extends BaseController {

	@Autowired
	private CertimgService certimgService;
	
	/**
	 * 跳转到资质主页面
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "cert/index";
	}
	
	/**
	 * 跳转到资质分类页面
	 * @return
	 */
	@RequestMapping("/type")
	public String type( Model model ) {
		
		// 查询所有的资质数据
		List<CertImg> cis = certimgService.queryAll();
		model.addAttribute("cis", cis);
		
		List<AccCertimg> acis = certimgService.queryAccCertimgs();
		model.addAttribute("acis", acis);
		
		return "cert/type";
	}
	
	/**
	 * 跳转到资质新增页面
	 * @return
	 */
	@RequestMapping("/add")
	public String add() {
		return "cert/add";
	}
	
	/**
	 * 跳转到资质修改页面
	 * @return
	 */
	@RequestMapping("/edit/{id}")
	public String edit( @PathVariable("id")Integer id, Model model ) {
		
		CertImg ci = certimgService.queryById(id);
		model.addAttribute("ci", ci);
		
		return "cert/edit";
	}
	
	
	/**
	 * 资质分类
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/operation")
	public Object operation( Integer ciid, String acctype, String flg ) {
		start();
		
		try {
			
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("ciid", ciid);
			paramMap.put("acctype", acctype);
			
			if ( "1".equals(flg) ) {
				certimgService.insertAccCertimg(paramMap);
			} else {
				certimgService.deleteAccCertimg(paramMap);
			}
			success(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			success(false);
		}
		
		return end();
	}
	
	/**
	 * 新增资质数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insert")
	public Object insert( CertImg ci ) {
		start();
		
		try {
			certimgService.insertCertimg(ci);
			success(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			success(false);
		}
		
		return end();
	}
	
	/**
	 * 修改资质数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Object update( CertImg ci ) {
		start();
		
		try {
			certimgService.updateCertimg(ci);
			success(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			success(false);
		}
		
		return end();
	}
	
	/**
	 * 删除资质数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deletes")
	public Object deletes( Datas ds ) {
		start();
		
		try {
			certimgService.deleteCertimgs(ds);
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
		
		Page<CertImg> page = certimgService.queryCertimgDatas(paramMap);
		page.setDraw(draw);
		return page;
	}
}
