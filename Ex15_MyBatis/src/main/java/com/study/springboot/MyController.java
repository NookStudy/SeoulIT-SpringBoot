package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.jdbc.IMyUserDAO;

@Controller
public class MyController {
	
	//MyBatis 사용을 위한 자동주입
	@Autowired
	private IMyUserDAO userdao;
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "MyBatis 사용하기";
	}
	
	@RequestMapping("/user")
//	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userlistPage(Model model) {
		//DAO(Mapper)의 getUser()메서드를 호출해서 게시물 목록을 인출
		model.addAttribute("users",userdao.getUser());
		
		return "userlist";
	}
}
