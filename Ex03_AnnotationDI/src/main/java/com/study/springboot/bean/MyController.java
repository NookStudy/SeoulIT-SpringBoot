package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyController {
	//단순히 타입만으로 자바빈을 자동주입 받는다.
	//빈이 생성될 때 member1변수가 참조할 객체를 자동으로 찾아온다.
	@Autowired
	Member member1;
	//타입과 이름가지 지정해서 자바빈을 자동주입 받는다.
	@Autowired
	@Qualifier("printerB")
	Printer printer;
	@Autowired
	Member member2;
	
	//웹브라우저에서 사용자가 /로 get방식의 url호출을 하면 다음 라인의 root()를 실행시킨다.
	@RequestMapping("/")
	/*
	 	@ResponseBody 어노테이션은 Json, XML등 REST Api형태의 응답을 할 경우
	 	(html없이 스트링 데이터만 보낼때) 지정한다.
	 */
	public @ResponseBody String root() {
		/*
		 	어노테이션을 통해 자동으로 빈을 주입받으므로 메서드내에는
		 	주입을 위한 코드는 필요하지 않다 (ex>getBean)
		 */
		//1.Member Bean 가져오기
		member1.print();
		
		//2.PrinterB Bean 가져오기
		member1.setPrinter(printer);
		member1.print();
		
		//3.싱글통 확인
		if (member1==member2) {
			System.out.println("동일한 객체입니다.");
		} else {
			System.out.println("서로 다른 객체입니다.");
		}
		return "Annotation 사용하기";
	}
}
