package com.study.springboot.jdbc;

import lombok.Data;

//회원관리를 위한 MyUser테이블에 대한 DTO
@Data
public class MyUserDTO {

	private String id;
	private String name;
}
