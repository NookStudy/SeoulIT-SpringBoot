package com.study.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.jdbc.IDAO;


@Controller
public class MyController {
	
	//MyBatis 사용을 위해 자동 주입
	@Autowired
	private IDAO userdao; //약한결합으로 주입 받는다.
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "MyBatis : 복잡한(join) 쿼리 결과 출력하기";
	}
	
	@RequestMapping("/employee") //프론트 컨트롤러
	public String userlistPage(Model model) {
		
		model.addAttribute("employees",userdao.getEmployee());
		return "/employeelist";
	}
	
}
