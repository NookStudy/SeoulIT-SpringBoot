package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "Validator (1)";
	}
	
	@RequestMapping("/insertForm")
	public String insert1() {
		return "createPage";
	}
	
	/*
	 @ModelAttribute(“dto”) 를 써 놓았기 때문에 jsp 페이지에서 dto 를 이용한 요소 접근이 가능해집니다.
		${dto.id}
		${dto.writer}
		${dto.content}
	 */
	
	//Validator 인터페이스를 통한 폼값 유효성 검증
	@RequestMapping("/create")
	public String insert2(@ModelAttribute("dto") ContentDTO contentDTO, 
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
		
		//폼값 검증을 위해 객체를 생성한다.
		ContentValidator validator = new ContentValidator();
		//폼값 검증을 위해 메서드를 호출한다.
		validator.validate(contentDTO, result); //검증
		//폼값 검증에 실패했는지 확인한다.
		if (result.hasErrors()) {
			//실패한 경우 재입력을 받기위해 쓰기페이지 경로를 설정한다.
			page = "createPage";	//에러가 있다면 원래페이지로 돌아감
		}
		return page;
	}
}
