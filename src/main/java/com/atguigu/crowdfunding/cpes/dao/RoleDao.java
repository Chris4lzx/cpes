package com.atguigu.crowdfunding.cpes.dao;

import java.util.List;
import java.util.Map;

import com.atguigu.crowdfunding.bean.Datas;
import com.atguigu.crowdfunding.cpes.bean.Role;
import com.atguigu.crowdfunding.cpes.bean.RolePermissionCount;

public interface RoleDao {

	Integer getAllCount();

	List<Role> getRolePage(Map<String, Integer> map);

	List<RolePermissionCount> getrpCount(Map<String, Object> roleMap);

	void insertRole(Role role);

	Role getRoleById(Integer id);

	void updateRole(Role role);

	void delete(Datas datas);

	void assign(Map<String, Object> map);

	void deleteRP(Integer roleid);
	
	List<Role> queryAll();

}
