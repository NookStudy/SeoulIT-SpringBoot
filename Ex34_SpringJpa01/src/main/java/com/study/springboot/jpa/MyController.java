package com.study.springboot.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() throws Exception{
		return "menu";
	}
	
	@RequestMapping("/insert")
	public String insert(@RequestParam("username") String username, Model model	) {
		//데이터 3개정도 추가하고 테스트
		Member member = Member.builder()
					.username(username)
					.createDate(LocalDate.now())
					.build();
		Member result = memberService.insert(member);
		model.addAttribute("member",result);
		
		return "insert";
 	}
	
	@RequestMapping("/select")
	public String select(@RequestParam("id") Long id, Model model) {
		Optional<Member> result = memberService.select(id);
		if (result.isPresent()) {
			model.addAttribute("member",result.get());
		}else {
			model.addAttribute("member",null);
		}
		
		return "select";
	}
	
	@RequestMapping("selectAll")
	public String selectAll(Model model) {
		List<Member> result = memberService.selectall();
		model.addAttribute("members",result);
		
		return "selectAll";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		memberService.delete(id);
		return "delete";
	}
	
	@RequestMapping("/update")
	public String update(Member member, Model model) {
		Member result = memberService.update(member);
		model.addAttribute("member",result);
		
		return "update";
	}
}
