package com.study.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dao.ISimpleBbsDAO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	//MyBatis 사용을 위해 자동 주입
	@Autowired
	ISimpleBbsDAO dao; //약한결합으로 주입 받는다.
	
	@RequestMapping("/")
	public String root() throws Exception{
		// MyBatis : resultnum
		return "redirect:list"; //list로 보냄
	}
	
	@RequestMapping("/list") //프론트 컨트롤러
	public String userlistPage(Model model) {
		/*
		 	DAO 클래스의 select()메서드를 호출하여 회원목록을 List로 반환받은 후
		 	Model긱체에 저장하고 View로 반환한다.
		 */
		model.addAttribute("list",dao.listDAO());
		
		int nTotalCount = dao.articleCount();
		model.addAttribute("count",nTotalCount);
		System.out.println("Count : " + nTotalCount);
		
		
		return "/list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request,Model model) {
		String sId = request.getParameter("id");
		model.addAttribute("dto",dao.viewDAO(sId));
		return "/view";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "/writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request,Model model) {
		String sName = request.getParameter("writer");
		String sTitle = request.getParameter("title");
		String sContent = request.getParameter("content");
		
		Map<String, String> map = new HashMap<>();
		map.put("item1", sName);
		map.put("item2", sTitle);
		map.put("item3", sContent);
		
		int nResult = dao.writeDAO(map);
		System.out.println("Write : "+nResult);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,Model model) {
		dao.deleteDAO(request.getParameter("id"));
		return "redirect:list";
	}
}
