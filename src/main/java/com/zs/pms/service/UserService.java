package com.zs.pms.service;

import java.util.List;

import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.vo.QueryUser;

public interface UserService {
	//���Է���
	public void hello();
	//�����û�id���Ȩ���б�
	public List<TPermission> queryByUid(int id);
	//����ԭ�е�Ȩ������˵�
	public List<TPermission> getMenu(List<TPermission> permissions);
	//������ѯ
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
	public List<TUser> queryByPage(int page,QueryUser queryUser);
	//������ҳ��
	public int queryPageCont(QueryUser queryUser);
}
