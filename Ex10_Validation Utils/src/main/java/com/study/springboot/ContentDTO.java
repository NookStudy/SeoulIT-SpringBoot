package com.study.springboot;

import lombok.Data;

//컨트롤러로 전송되는 폼값을 한꺼번에 저장하기 위한 커맨드 객체로 활용
@Data
public class ContentDTO {
	private int id;
	private String writer;
	private String content;
}
