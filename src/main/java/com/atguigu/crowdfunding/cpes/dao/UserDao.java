package com.atguigu.crowdfunding.cpes.dao;

import java.util.List;
import java.util.Map;

import com.atguigu.crowdfunding.bean.Datas;
import com.atguigu.crowdfunding.cpes.bean.Permission;
import com.atguigu.crowdfunding.cpes.bean.User;
import com.atguigu.crowdfunding.cpes.bean.UserRoleCount;

public interface UserDao {

	User queryUserByLoginacct(String loginacct);

	List<User> queryUserDatas(Map<String, Object> paramMap);

	List<UserRoleCount> queryUserRoleCount(Map<String, Object> map);

	int queryUserCount(Map<String, Object> paramMap);

	void insertUser(User user);

	User queryById(Integer id);

	void updateUser(User user);

	void deleteUsers(Datas ds);

	List<Integer> queryUserRoleById(Integer id);

	void insertUserRole(Map<String, Object> paramMap);

	void deleteAllRoles(Integer id);

	void deleteUserRoles(Map<String, Object> paramMap);

	void deleteAllUserRole(Integer id);

	List<Permission> queryPermissions(User loginUser);

}
