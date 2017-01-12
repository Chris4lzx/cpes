package com.atguigu.crowdfunding.cpes.service;

import java.util.List;
import java.util.Map;

import com.atguigu.crowdfunding.bean.Datas;
import com.atguigu.crowdfunding.bean.Page;
import com.atguigu.crowdfunding.cpes.bean.Role;

public interface RoleService {

	Page<Role> queryRoleDatas(Map<String, Integer> map);

	void insertRole(Role role);

	Role getRoleById(Integer id);

	void updateRole(Role role);

	void delete(Datas datas);

	void assign(Datas datas, Integer roleid);

	List<Role> queryAll();

}
