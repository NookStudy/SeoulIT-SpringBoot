package com.study.springboot;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

//컨트롤러로 전송되는 폼값을 한꺼번에 저장하기 위한 커맨드 객체로 활용
@Data
public class ContentDTO {
	/*
	 어노테이션을 통한 폼값 검증을 위해서는 추가전인 디펜더시 필요
	 
	 */
	/*
	 	@JsonProperty : json 형식의 데이터를 받음
	 	@NotNull : null이 ㅇ안되게
	 	@NotEmpty : 빈값 안되게
	 	@Min	 : 상수값 최소값
	 	@Size : 문자열에 해단 길이 지정 (message: 저건에 맞지 ㅇ낳을 때의 메시지)
	 */
	private int id;
	//폼값이 null이면 메세지 출력
	@NotNull(message = "writer is null")
	//빈값일때 출력
	@NotEmpty(message = "writer is empty")
	//입력값의 길이를 최소~최대로 지정. 해당범위 벗어나면 메세지 출력
	@Size(min=3, max = 10, message = "writer min3, max 10.")
	private String writer;
	@NotNull(message = "content is null")
	@NotEmpty(message = "contnet is empty")
	private String content;
}
