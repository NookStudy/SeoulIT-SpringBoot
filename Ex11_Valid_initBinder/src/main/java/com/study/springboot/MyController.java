package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.study.springboot.*;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "Validator (3)";
	}
	//글쓰기 폼 매핑
	@RequestMapping("/insertForm")
	public String insert1() {
		return "createPage";
	}
	
	
	//Validator 인터페이스를 통한 폼값 유효성 검증
	/*
 		폼값이 전송되면 contentDto객체를 통해 한꺼번에 받ㅇ음.
 		해당 객체에는 폼값 검증을 위한 어노테이셔이 추가되어 있으므로
 		해당 객체를 통해 검증을 하겠다는 의미로 @validated를 추가해야 한다.
	 */
	@RequestMapping("/create")
	//의존성 추가로 @valid 어노테이션 추가
	public String insert2(@ModelAttribute("dto") @Validated ContentDTO contentDTO, 
							BindingResult result) {
		/*
		 	해당 메서드의 첫번째 매개변수는 폼값을 한꺼번에 받을 수 있는
		 	커맨드객체를 정의한다.
		 	폼값을 받은 후 View로 전달할 때는 
		 	@ModelAttribute 를 통해 객체명을 dto로 변경한다.
		 	두번째 매개변수 BindingResult 객체는 폼값검증의 결과를 확인하기 위해 정의한다.
		 */
		String page = "createDonePage";
		System.out.println(contentDTO);
		/*
		 	@Validatied 를 붙임으로 밑의 두줄이 필요없어짐
		 */
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
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new com.study.springboot.ContentValidator());
	}
}
