package com.atguigu.crowdfunding.cpes.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowdfunding.bean.Datas;
import com.atguigu.crowdfunding.bean.Page;
import com.atguigu.crowdfunding.cpes.bean.Role;
import com.atguigu.crowdfunding.cpes.bean.RolePermissionCount;
import com.atguigu.crowdfunding.cpes.dao.RoleDao;
import com.atguigu.crowdfunding.cpes.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public void delete(Datas datas) {
		roleDao.delete(datas);
		
	}
	
	@Override
	public Page<Role> queryRoleDatas(Map<String, Integer> map) {
		
		Integer records = roleDao.getAllCount();
		
		List<Role> roles = roleDao.getRolePage(map);
		
		Map<String,Object> roleMap = new HashMap<String, Object>();
		
		roleMap.put("roles", roles);
		
		List<RolePermissionCount> list = roleDao.getrpCount(roleMap);
			for (RolePermissionCount rpCount : list) {
				for (Role r: roles) {
					if (rpCount.getRoleid().equals(r.getId())) {
						r.setCount(rpCount.getRpcount());
					}
				}
			}
		
		
		Page<Role> rolePage = new Page<>();
		
		rolePage.setRecordsTotal(records);
		
		rolePage.setData(roles);
		rolePage.setRecordsFiltered(records);
		
		for (int i = 0; i < roles.size(); i++) {
			roles.get(i).setIndex(i+1);
		}
		
		
		return rolePage;
	}

	@Override
	public void insertRole(Role role) {
		
		roleDao.insertRole(role);
		
	}

	@Override
	public Role getRoleById(Integer id) {
		return roleDao.getRoleById(id);
	}

	@Override
	public void updateRole(Role role) {
		
		roleDao.updateRole(role);
		
	}

	@Override
	public void assign(Datas datas, Integer roleid) {
		
		roleDao.deleteRP(roleid);
		Map<String, Object> map = new HashMap<>();
		List<Integer> ids = datas.getIds();
		map.put("ids", ids);
		map.put("roleid", roleid);
		
		roleDao.assign(map);
	}

	@Override
	public List<Role> queryAll() {
		return roleDao.queryAll();
	}

}
