package com.study.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springboot.dto.SimpleBbsDTO;

//@repository 어노테이션을 통해 스프링컨테이너 시작시 자동으로 빈이 생성된다.
@Repository //data관련된 것이 있을 때
public class SimpleBbsDAO implements IsSimpleBbsDAO{
	/*
	  인터레이스를 구혀한 클래스이므로 추상베서드를 일괄적으로 오버라이딩 해야한다.
	  따라서 이부분은 자동완성 기능을 사용하면 편리다.
	 */
	//JDBC작업을 위해 자동주입
	@Autowired
	JdbcTemplate template;
	
	//게시판 조회
	@Override
	public List<SimpleBbsDTO> listDAO(){
		System.out.println("listDAO()");
		
		String query = "select * from simple_bbs order by id desc";
		List<SimpleBbsDTO> dtos = template.query(query, new BeanPropertyRowMapper<SimpleBbsDTO>(SimpleBbsDTO.class));
		//쿼리 결과가 많으면 query
		return dtos;
	}
	
	//게시물 조회
	@Override
	public SimpleBbsDTO viewDAO(String id) {
		System.out.println("viewDAO()");
		
		String query = "select * from simple_bbs where id = "+ id;
		/*
		 	하나의 레코드를 반환하는 select 쿼리문이므로 queryForObject메서드 사용.
		 	두번째 인자를 통해 인출한 레코드를 DTO에 자동으로 저장.
		 	세번째 인자를 통해 뭐리문츼 인파라미터를 설정. 이때 Object형 배열을 사용.
		 	(예: new Object[]{memberDTO.getID()})
		 	여기서는 사용 안됨
		 */
		SimpleBbsDTO dto = template.queryForObject(query, new BeanPropertyRowMapper<>(SimpleBbsDTO.class));
		
		return dto;
	}
	
	
	@Override
	public int writeDAO(final String writer, final String title, final String content) {
		System.out.println("writeDAO()");
		/*
		 	insert, delete, update와 같이 행의 변화가 생시는 쿼리문을 실행할 때는
		 	update() 메서드 사용.
		 	실행결과로 반환된 행의 갯수. 즉, 입력된 행의 갯수가 변환되게 된다.
		 */
		//인파라미터가 있는 쿼리문 작성
		String query =
				"insert into simple_bbs(id,writer,title,content) values(simple_bbs_seq.nextval,?,?,?)";
		//업데이트 데이터가 한개 또는 여러개 있을 때
		return template.update(query,writer,title,content);
	}
	
	@Override
	public int deleteDAO(final String id) {
		System.out.println("deleteDAO()");
		
		String query = "delete from simple_bbs where id = ?";
		return template.update(query,Integer.parseInt(id));
	}
}
