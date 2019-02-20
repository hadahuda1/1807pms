package com.zs.pms.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUserService {
	@Autowired
	UserService userService;
	
	public void testHello() {
		userService.hello();
	}
	
	public void testlogin() {
		List<TPermission> list = userService.queryByUid(1);
		for(TPermission permission : list) {
			System.out.println(permission.getPname());
		}
		System.out.println("********************************************");
		for(TPermission permission : userService.getMenu(list)) {
			//一级权限
			System.out.println(permission.getPname());
			for(TPermission permission2 : permission.getChildren()) {
				System.out.println("********"+permission2.getPname());
			}
		}
	}
	
	public void testQuery() {
		//查询对象
		QueryUser queryUser = new QueryUser();
		for(TUser user : userService.queryByPage(2, queryUser)) {
			System.out.println(user.getId()+"___"+user.getLoginname());
		}
		System.out.println("共"+userService.queryPageCont(queryUser)+"页");
	}
	
	public void testDelete() {
		int [] ids = {5,6,7,8};
		userService.deleteByIds(ids);
	}

	public void testupdate() {
		TUser tUser = new TUser();
		TDep tDep = new TDep();
		tUser.setBirthday(new Date());
		tUser.setDept(tDep);
		tDep.setId(6);
		tUser.setEmail("1111up@qq.com");
		tUser.setId(4);
		tUser.setIsenabled(-1);
		tUser.setLoginname("test");
		tUser.setPassword("1234");
		tUser.setRealname("ss");
		tUser.setSex("男");
		tUser.setUpdator(1);
		userService.updateUser(tUser);
	}
	@Test
	public void testinsert() {
		TUser tUser = new TUser();
		TDep tDep = new TDep();
		tUser.setBirthday(new Date());
		tUser.setDept(tDep);
		tDep.setId(6);
		tUser.setEmail("1455878202@qq.com");
		tUser.setIsenabled(1);
		tUser.setLoginname("dada");
		tUser.setPassword("12inser1234");
		tUser.setRealname("inser");
		tUser.setSex("女");
		tUser.setCreator(1);
		tUser.setPic("2insert");
		userService.insertUser(tUser);
	}

	public void testdeletebyid() {
		userService.deleteById(1005);
	}
}
