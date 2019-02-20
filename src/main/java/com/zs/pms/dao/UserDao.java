package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.vo.QueryUser;

public interface UserDao {
	//根据用户id获得权限列表
	public List<TPermission> queryByUid(int id);
	//根据条件查询
	public List<TUser> queryByCon(QueryUser queryUser);
	//批量删除
	public void deleteByIds(int[]ids);
	//修改
	public void updateUser(TUser tUser);
	//新增
	public int insertUser(TUser tUser);
	//删除一条
	public void deleteById(int id);
	//分页查询
	public List<TUser> queryByPage(QueryUser queryUser);
	//获得总条数
	public int queryCount(QueryUser queryUser);
}
