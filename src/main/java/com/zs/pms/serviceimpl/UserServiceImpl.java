package com.zs.pms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.pms.dao.UserDao;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.Constants;
import com.zs.pms.vo.QueryUser;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;
	@Override
	public void hello() {
		// TODO Auto-generated method stub
		System.out.println("Hello Spring");
	}
	
	@Override
	public List<TPermission> queryByUid(int id) {
		// TODO Auto-generated method stub
		return dao.queryByUid(id);
	}

	@Override
	public List<TPermission> getMenu(List<TPermission> permissions) {
		// TODO Auto-generated method stub
		//����������
		List<TPermission> list = new ArrayList<>();
		//����Ȩ���б�
		for(TPermission permission : permissions) {
			//һ���˵�
			if (permission.getLev()==1) {
				//���ض����˵�  ����
				for(TPermission permission2:permissions) {
					//�����˵�Ȩ�޵���һ��Ȩ��id
					if (permission2.getPid()==permission.getId()) {
						permission.addChild(permission2);
					}
				}
				//�ӵ���Ȩ��
				list.add(permission);
			}
		}
		return list;
	}

	@Override
	public List<TUser> queryByCon(QueryUser queryUser) {
		// TODO Auto-generated method stub
		return dao.queryByCon(queryUser);
	}

	@Override
	public void deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		dao.deleteByIds(ids);
	}

	@Override
	public void updateUser(TUser tUser) {
		// TODO Auto-generated method stub
		dao.updateUser(tUser);
	}

	@Override
	//���������ҵ�����
	@Transactional(rollbackFor=Exception.class)
	public int insertUser(TUser tUser) {
		// TODO Auto-generated method stub
		dao.insertUser(tUser);
		int a = 1/0;
		return tUser.getId();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<TUser> queryByPage(int page, QueryUser queryUser) {
		// TODO Auto-generated method stub
		//��ʼ����1��ʼ
		int start = (page - 1) * Constants.PAGECONT+1;
		//��ֹ��
		int end = page*Constants.PAGECONT;
		queryUser.setEnd(end);
		queryUser.setStart(start);
		return dao.queryByPage(queryUser);
	}

	@Override
	public int queryPageCont(QueryUser queryUser) {
		// TODO Auto-generated method stub
		//ͨ��������������ҳ��
		int cont =dao.queryCount(queryUser);
		//������
		if (cont%Constants.PAGECONT==0) {
			return cont/Constants.PAGECONT;
		}else {
			
			return cont/Constants.PAGECONT+1;
		}
	}
	
	
}
