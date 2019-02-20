package com.zs.pms.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.service.UserService2;
import com.zs.pms.vo.QueryUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class testUserService2 {
	@Autowired
	UserService2 userService2;
	@Test
	public void testQuery() {
		QueryUser queryUser = new QueryUser();
		queryUser.setSex("ÄÐ");
		System.out.println(userService2.queryByCon(queryUser).size());
	}
}
