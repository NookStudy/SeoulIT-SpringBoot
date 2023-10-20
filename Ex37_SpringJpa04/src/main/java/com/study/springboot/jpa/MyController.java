package com.study.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.persistence.PreUpdate;

@Controller
public class MyController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() throws Exception{
		return "menu";
	}
	
	@RequestMapping("/selectNameLike1")
	public String selectMembers1(@RequestParam("name") String search, 
									Model model) {
		System.out.println("***1:"+search+"***");
		String name = search +"%";

		List<Member> result = memberService.selectmembers1(name);
		
		model.addAttribute("members",result);
		
		return "select_name_list_1";
		
		
		
		
	}
	@RequestMapping("/selectNameLike2")
	public String selectMembers2(@RequestParam("name") String search, 
							Model model) {
		System.out.println("***2:"+search+"***");
		String name = search +"%";
		Sort sort = Sort.by(Sort.Order.asc("id"));
		
		List<Member> result = memberService.selectMembers2(name,sort);
		
		model.addAttribute("members",result);
		
		return "select_name_list_1";
		
	}
	
	@RequestMapping("/selectNameLike3")
	public String selectMembers3(@RequestParam("name") String search, 
									@RequestParam("page") String page,
									Model model) {
		System.out.println("***3:"+search+"***");
		System.out.println("***3"+page+"***");
		
		String name = search +"%";
		Sort sort = Sort.by(Sort.Order.desc("id"));
		int nPage = Integer.parseInt(page) -1;
		
		//페이지는 0부터
		Pageable pageable = PageRequest.ofSize(10).withPage(nPage).withSort(sort);
		
		Page<Member> result = memberService.selectMembers3(name,pageable);
		List<Member> content = result.getContent();
		long totalElements = result.getTotalElements();
		int totalPages = result.getTotalPages();
		int size = result.getSize();
		int pageNumber = result.getNumber() +1;	//0부터 시작이므로
		int numberofElements = result.getNumberOfElements(); //contents 갯수
				
		model.addAttribute("members",content);
		model.addAttribute("totalElements",totalElements);
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("size",size);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("numberOfElements",numberofElements);
		
		return "select_name_list_2";
	}
	
	@RequestMapping("/selectNameLike4")
	public String selectMembers4(@RequestParam("name") String search, Model model) {
		System.out.println("***4:"+search+"***");
		String name = search +"%";
		
		List<Member> result = memberService.selectMembers4(name);
		
		model.addAttribute("members",result);
		
		return "select_name_list_1";
	}
	
}
