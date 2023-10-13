package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "Validator (4)";
	}
	@RequestMapping("/insertForm")
	public String insert1() {
		return "createPage";
	}
	
	
	@RequestMapping("/create")
	public String insert2(@ModelAttribute("dto") @Valid ContentDTO contentDTO, 
							BindingResult result) {
		String page = "createDonePage";
		System.out.println(contentDTO);
		
//		ContentValidator validator = new ContentValidator();
//		validator.validate(contentDTO, result);
		if (result.hasErrors()) {
			System.out.println("getAllErrors : "+result.getAllErrors());
			
			if (result.getFieldError("writer")!= null) {
				System.out.println("1:"+result.getFieldError("writer").getCode());
			}
			if (result.getFieldError("content")!= null) {
				System.out.println("2:"+result.getFieldError("content").getCode());
			}
			page = "createPage";	//에러가 있다면 원래페이지로 돌아감
		}
		return page;
	}
	
	//검증을 위한 클래스를 대체. ContnetValidator가 필요없다
	//이제 이마저도 필요없다
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(new ContentValidator());
//	}
}
