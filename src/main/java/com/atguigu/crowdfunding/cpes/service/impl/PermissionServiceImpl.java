package com.atguigu.crowdfunding.cpes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowdfunding.cpes.bean.Permission;
import com.atguigu.crowdfunding.cpes.dao.PermissionDao;
import com.atguigu.crowdfunding.cpes.service.PermissionService;
@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private PermissionDao permissionDao;

	@Override
	public List<Permission> getAll() {
		
		return permissionDao.selectAll();
	}

	@Override
	public void insert(Permission permission) {
		permissionDao.insert(permission);
	}

	@Override
	public void delete(Integer id) {
		
		permissionDao.deleteByPrimaryKey(id);
		
	}

	@Override
	public Permission getPermissionById(Integer id) {

		return permissionDao.selectByPrimaryKey(id);
	}

	@Override
	public void update(Permission permission) {

		permissionDao.updateByPrimaryKey(permission);
		
	}
	
}
