package com.atguigu.crowdfunding.cpes.bean;

public class RolePermissionCount {

	private Integer roleid;
	private Integer rpcount;
	public RolePermissionCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RolePermissionCount(Integer roleid, Integer rpcount) {
		super();
		this.roleid = roleid;
		this.rpcount = rpcount;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public Integer getRpcount() {
		return rpcount;
	}
	public void setRpcount(Integer rpcount) {
		this.rpcount = rpcount;
	}
	
	
}
