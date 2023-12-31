package com.study.springboot.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.*;

//@Repository  어노테이션을 통해 스프링 컨테이너 시작시 자동으로 빈이 생성됨
@Repository
public class MyUserDAO {
	//jdbc작업을 위해 자동주입 받는다
	@Autowired
	//자동으로 오라클안의 객체를 연결
	//application.properties,의 오라클 정보 사용
	private JdbcTemplate jdbcTemplate;
	
	public java.util.List<MyUserDTO> listForBeanPropertyRowMapper(){
		String query = "select * from myuser"; //결과가 여러개
		/*
		 	2개이상의 레코드를 인출하는 select 쿼리문을 실행할때 query()메서드를 호출한다.
		 	두번째 인수인 RowMapper가 인칠된 레코드를 DTO에 저장한 후 
		 	List에 추가하여 반환.
		 	즉 ResultSet을 저장하기 위한 반복적인 작업을 자동으로 처리해 준다.
		 */
		List<MyUserDTO> list = 
				jdbcTemplate.query(query, new BeanPropertyRowMapper<MyUserDTO>(MyUserDTO.class));
//		jdbcTemplate.query(query, new BeanPropertyRowMapper<(생략가능)>(MyUserDTO.class));
		
//		for (MyUserDTO my : list) {
//			System.out.println(my);
//		}
		
		return list;
	}
	

}
