package com.study.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	public String insert(Member member, Model model) {
		memberService.insert();
		
		return "insert";
 	}
	
	@RequestMapping("/selectById")
	public String selectById(@RequestParam("id") Long search, Model model) {
		Optional<Member> result = memberService.selectId(search);
			model.addAttribute("member",result.get());
		
		return "select_id";
	}
	
	@RequestMapping("/selectByName")
	public String selectByName(@RequestParam("name") String search, Model model) {
		Optional<Member> result = memberService.selectName(search);
		model.addAttribute("member",result.get());
		
		return "select_name";
	}
	
	@RequestMapping("/selectByEmail")
	public String selectByEmail(@RequestParam("email") String search, Model model) {
		Optional<Member> result = memberService.selectEmail(search);
		model.addAttribute("member",result.get());
		
		return "select_name";
	}
	
	@RequestMapping("/selectByNameLike")
	public String selectByNameLike(@RequestParam("name") String search, Model model) {
		String name = search +"%";
		List<Member> result = memberService.selectNameLike(name);
		model.addAttribute("members",result);
		
		return "select_name_list";
	}
	
	@RequestMapping("/selectByNameLikeNameDesc")
	public String selectByNameLikeNameDesc(@RequestParam("name") String search, Model model) {
		String name = search +"%";
		List<Member> result = memberService.selectNameLikeNameDesc(name);
		model.addAttribute("members",result);
		
		return "select_name_list";
	}
	
	@RequestMapping("/selectByNameLikeOrder")
	public String selectByNameLikeOrder(@RequestParam("name") String search, Model model) {
		String name = search +"%";
		Sort sort = Sort.by(Sort.Order.desc("name"));
//		Sort sort = Sort.by(Sort.Order.desc("name"),Sort.Order.asc("email"));
		
		List<Member> result = memberService.selectNameLike(name,sort);
		model.addAttribute("members",result);
		
		return "select_name_list";
	}
	
	@RequestMapping("selectAll")
	public String selectAll(Model model) {
		List<Member> result = memberService.selectall();
		model.addAttribute("members",result);
		
		return "selectAll";
	}
	
//	@RequestMapping("/delete")
//	public String delete(@RequestParam("id") Long id) {
//		memberService.delete(id);
//		return "delete";
//	}
//	
//	@RequestMapping("/update")
//	public String update(Member member, Model model) {
//		Member result = memberService.update(member);
//		model.addAttribute("member",result);
//		
//		return "update";
//	}
}
