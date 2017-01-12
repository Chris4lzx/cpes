package com.atguigu.crowdfunding.cpes.service;

import java.util.List;
import java.util.Map;

import com.atguigu.crowdfunding.bean.Datas;
import com.atguigu.crowdfunding.bean.Page;
import com.atguigu.crowdfunding.cpes.bean.Permission;
import com.atguigu.crowdfunding.cpes.bean.Role;
import com.atguigu.crowdfunding.cpes.bean.User;

public interface UserService {

	User queryUserByLoginacct(String loginacct);

	Page<User> queryUserDatas(Map<String, Object> paramMap);

	void insertUser(User user);

	User queryById(Integer id);

	void updateUser(User user);

	void deleteUsers(Datas ds);

	List<Integer> queryUserRoleById(Integer id);

	void insertUserRole(Integer id, Datas ds);

	void insertAllUserRole(Integer id, List<Role> rs);

	void deleteUserRole(Integer id, Datas ds);

	void deleteAllUserRole(Integer id);

	List<Permission> queryPermissions(User loginUser);

}
