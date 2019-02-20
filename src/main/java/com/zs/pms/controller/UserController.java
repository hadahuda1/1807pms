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
	//���ط�ҳ����
	model.addAttribute("LIST", us.queryByPage(Integer.parseInt(page), query));
	//������ҳ��
	model.addAttribute("PAGECONT", us.queryByCon(query));
	//��ǰҳ��
	model.addAttribute("PAGE", page);
	//����
	model.addAttribute("QUERY",query);
	return  "user/list";
	
}
}
