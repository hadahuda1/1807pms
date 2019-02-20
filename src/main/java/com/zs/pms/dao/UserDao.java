package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.vo.QueryUser;

public interface UserDao {
	//�����û�id���Ȩ���б�
	public List<TPermission> queryByUid(int id);
	//����������ѯ
	public List<TUser> queryByCon(QueryUser queryUser);
	//����ɾ��
	public void deleteByIds(int[]ids);
	//�޸�
	public void updateUser(TUser tUser);
	//����
	public int insertUser(TUser tUser);
	//ɾ��һ��
	public void deleteById(int id);
	//��ҳ��ѯ
	public List<TUser> queryByPage(QueryUser queryUser);
	//���������
	public int queryCount(QueryUser queryUser);
}
