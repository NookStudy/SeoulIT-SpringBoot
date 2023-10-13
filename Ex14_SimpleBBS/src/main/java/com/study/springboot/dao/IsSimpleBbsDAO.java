package com.study.springboot.dao;

import java.util.List;

import com.study.springboot.dto.SimpleBbsDTO;

//서비스 인터페이스 : 컨트롤러와 모델(DAO) 사이에서 매개역할을 함
public interface IsSimpleBbsDAO {
	/*
	 	추상메서드 정의 시 매개변수는 일괄적으로 DTO객체를 사용한다.
	 	커맨드 객체를 사용하면 인수를 한꺼번에 받아 전달할 수 있고, 
	 	인수의 갯수에 변경이 있더라도 DTO객체만 수정하면 되므로 
	 	프로그램 작성이 쉬워진다.
	 */
	public List<SimpleBbsDTO> listDAO();
	public SimpleBbsDTO viewDAO(String id);
	public int writeDAO(String writer, String title, String content);
	public int deleteDAO(String id);
}
