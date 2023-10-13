package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//폼값 검증을 위해 Validator 인터페이스를 구현한다.
public class ContentValidator implements Validator{
	/*
	 	폼값 검증을 위해 DTO 객체를 전달하게 되면 해당 메서드가 먼저 호출되어 
	 	전달된 DTO가 검증에 필요한 조건을 가진 커맨드객체인지 검사한다.
	 */
	@Override
	public boolean supports(Class<?> arg0) {
		return ContentDTO.class.isAssignableFrom(arg0);
	}
	
	/*
	  	폼값 검증을 진행하기 위한 메서드로 여기서는 if문을 통한 검증 방법을 사용하고 있다.
	  
	 */
	@Override
	public void validate(Object obj, Errors errors) {
		
		ContentDTO dto = (ContentDTO)obj;
		
		//작성자 검증.
		String sWriter = dto.getWriter();
		//작성자를 입력한 값이 null 혹은 빈값인지 호가인
		if (sWriter==null||sWriter.trim().isEmpty()) {
			System.out.println("Writer is null or empty");
			/*
			 	폼값 검증에 오류가 있는 경우 처리 형식.
			 	error객체. rejectValue(폼의 name속성, 에러객체명, 디폴트 메세지)
			 */
			errors.rejectValue("writer", "trouble");
		}
		
		String sContent = dto.getContent();
		if (sContent==null||sContent.trim().isEmpty()) {
			System.out.println("Content is null or empty");
			errors.rejectValue("content", "trouble");
		}
	}
}
