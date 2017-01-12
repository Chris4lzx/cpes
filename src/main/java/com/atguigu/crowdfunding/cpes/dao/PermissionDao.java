package com.atguigu.crowdfunding.cpes.dao;

import com.atguigu.crowdfunding.cpes.bean.Permission;
import java.util.List;

public interface PermissionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Integer id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);
}