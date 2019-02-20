package com.zs.pms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.DateUtil;
import com.zs.pms.utils.MD5;
import com.zs.pms.vo.QueryLogin;
import com.zs.pms.vo.QueryUser;

@Controller  //控制器
public class LoginController {
	@Autowired
	UserService us;
	//去登陆页面
	@RequestMapping("/tologin.do")
	public String tologin() {
		return "login";
	}
	//去主页
	@RequestMapping("/login.do")
	public String login(QueryLogin login,HttpSession session,ModelMap model) {
		//验证验证码
		String ocode =(String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//生成的验证码和页面的验证码不相等
		if (!ocode.equals(login.getChkcode())) {
			model.addAttribute("MSG", "验证码输入错误,请重新输入");
			return "login";
		}
		//验证账号密码  装载数据
		QueryUser query = new QueryUser();
		query.setLoginname(login.getUsername());
		//MD5加密
		MD5 md5 = new MD5();
		query.setPassword(md5.getMD5ofStr(login.getPassword()));
		query.setIsenabled(1);
		//返回登录的用户
		List<TUser> users = us.queryByCon(query);
		//登录失败
		if (users==null||users.size()!=1) {
			model.addAttribute("MSG", "用户名密码不匹配，请重新输入");
			return "login";
		}
		//登录成功          装session
		session.setAttribute("CUSER", users.get(0));
		return "main";
	}
	//去顶部
	@RequestMapping("/top.do")
	public String top(ModelMap model) {
		model.addAttribute("TODAY", DateUtil.getStrDate(new Date()));
		return "top";
	}
	//去左侧面
	@RequestMapping("/left.do")
	public String left(HttpSession session,ModelMap model) {
		//获得当前的登录用户
		TUser cu= (TUser) session.getAttribute("CUSER");
		//获得该用户的权限列表
		List<TPermission> list1 =us.queryByUid(cu.getId());
		//返回菜单
		model.addAttribute("MENU",us.getMenu(list1));
		return "left";
	}
	//去右侧面
	@RequestMapping("/right.do")
	public String right() {
		return "right";
	}
}
