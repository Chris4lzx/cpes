package com.atguigu.crowdfunding.cpes.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowdfunding.bean.Datas;
import com.atguigu.crowdfunding.bean.Page;
import com.atguigu.crowdfunding.cpes.bean.Permission;
import com.atguigu.crowdfunding.cpes.bean.Role;
import com.atguigu.crowdfunding.cpes.bean.User;
import com.atguigu.crowdfunding.cpes.bean.UserRoleCount;
import com.atguigu.crowdfunding.cpes.dao.UserDao;
import com.atguigu.crowdfunding.cpes.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public User queryUserByLoginacct(String loginacct) {
		return userDao.queryUserByLoginacct(loginacct);
	}

	public Page<User> queryUserDatas(Map<String, Object> paramMap) {
		// 分页对象
		Page<User> userpage = new Page<User>();
		
		// 查询数据
		List<User> users = userDao.queryUserDatas(paramMap);
		int index = 1;
		for ( User r : users ) {
			r.setIndex(index++);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("users", users);
		List<UserRoleCount> cnts = userDao.queryUserRoleCount(map);
		for ( UserRoleCount cnt : cnts ) {
			for ( User u : users ) {
				if ( cnt.getUserid().equals(u.getId()) ) {
					u.setCount(cnt.getUrcount());
				}
			}
		}
		
		// 查询数量
		int count = userDao.queryUserCount(paramMap);
		
		userpage.setData(users);
		userpage.setRecordsTotal(count);
		userpage.setRecordsFiltered(count);
		
		return userpage;
	}

	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	public User queryById(Integer id) {
		return userDao.queryById(id);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUsers(Datas ds) {
		userDao.deleteUsers(ds);
	}

	public List<Integer> queryUserRoleById(Integer id) {
		return userDao.queryUserRoleById(id);
	}

	public void insertUserRole(Integer id, Datas ds) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", id);
		
		for ( Integer roleid : ds.getIds() ) {
			paramMap.put("roleid", roleid);
			userDao.insertUserRole(paramMap);
		}
	}

	public void insertAllUserRole(Integer id, List<Role> rs) {
		userDao.deleteAllRoles(id);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", id);
		
		for ( Role role : rs ) {
			paramMap.put("roleid", role.getId());
			userDao.insertUserRole(paramMap);
		}
	}

	public void deleteUserRole(Integer id, Datas ds) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", id);
		paramMap.put("roleids", ds.getIds());
		userDao.deleteUserRoles(paramMap);
	}

	public void deleteAllUserRole(Integer id) {
		userDao.deleteAllRoles(id);
	}

	public List<Permission> queryPermissions(User loginUser) {
		return userDao.queryPermissions(loginUser);
	}
}
