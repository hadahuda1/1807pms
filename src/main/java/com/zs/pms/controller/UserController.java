package com.zs.pms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

@Controller
public class UserController {
@Autowired
UserService us;
@RequestMapping("/user/list.do")
public String list(String page,QueryUser query,ModelMap model) {
	if (page==null) {
		page="1";
	}
	//返回分页数据
	model.addAttribute("LIST", us.queryByPage(Integer.parseInt(page), query));
	//返回总页数
	model.addAttribute("PAGECONT", us.queryByCon(query));
	//当前页数
	model.addAttribute("PAGE", page);
	//条件
	model.addAttribute("QUERY",query);
	return  "user/list";
	
}
}
