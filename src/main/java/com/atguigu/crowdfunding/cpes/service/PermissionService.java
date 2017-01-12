package com.atguigu.crowdfunding.cpes.service;

import java.util.List;

import com.atguigu.crowdfunding.cpes.bean.Permission;

public interface PermissionService {

	List<Permission> getAll();

	void insert(Permission permission);

	void delete(Integer id);

	Permission getPermissionById(Integer id);

	void update(Permission permission);

}
