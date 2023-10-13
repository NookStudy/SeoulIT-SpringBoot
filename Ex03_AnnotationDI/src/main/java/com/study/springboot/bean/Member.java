package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//다음에 나오는 클래스인 Member클래스를 빈으로 등록 하겠다는 의미
@Component
public class Member {
	//멤버변수
	//빈 생성시 "홍길동" 초기값 자동부여
	//이 때 setter를 통해 값이 설정됨
	@Value("홍길동")
	private String name;
	@Value("도사")
	private String nickname;
	/*
	 	객체타입의 멤벼변수는 자동으로 주입받는다.
	 	이 때 @Qualifier annotation이 있으면 이름까지 지정하여 주입받게 된다.
	 	만약 부착하지 않으면 해당 타입으로 생성된 빈이 있는지 찾은 후 주입힌다.
	 */
	@Autowired
	@Qualifier("printerA")
	private Printer printer;
	
	//기본생성자, 인수생성자, getter,setter, toString() 메서드를 추가(자동생성 source 사용)
	public Member() {}
	
	/*
	 	클래스를 통해 객체를 생성할 때는 항상 생성자 메서드 호출을 통해 기술한다.
	 	생성자를 정의하지 않으면 컴파일러에 의해 디폴트 생성자(인수, 실행부가 없는 형태)가 만들어 진다.
	 	개발자가 생성자를 정의하면 기본생성자는 만들어지지 않으므로 필요에 따라 추가해야 함
	 */

	//인수 생성자
	public Member(String name, String nickname, Printer printer) {
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void print() {
		printer.print("Hello " + name + " : "+nickname);
	}
}
