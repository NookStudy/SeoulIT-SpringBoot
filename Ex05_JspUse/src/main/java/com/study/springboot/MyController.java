package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	//컨텍스트 로드 경로에 대한 매핑
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "JSP in Gradle";
	}
	
	//JSP를 뷰로 사용하기 위한 매핑
	@RequestMapping("test1")		//localhost:8081/test1
	public String test1()	{
		//뷰의 경로를 반환한다. 해당 파일은 views하위에 생성하면 된다.
		//(application.prefix에 WEB-INF/vews를 박았으므로)
		return "test1";				//실제 호출 될 /WEB-INF/views/test1.jsp
													//   prefix   test1 suffix
		
	}
	
	@RequestMapping("test2")		//localhost:8081/test2
	public String test2() {
		//뷰 경로를 폴더를 포함하여 지정한다.
		return "sub/test2";			//실제 호출 될 /WEB-INF/views/sub/test2.jsp
	}
}

