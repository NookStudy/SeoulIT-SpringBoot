package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * @SpringBootApplication은 간단해 보이지만 무려 세가지 어노테이션의 콤비네이션!
 		@configuration : bean 의 싱글톤 설정. 및 각종설정
 		@EnambleAutoConfiguration : 스프링 어클리케이션 컨텍스트 의 자동설정.
 		@componentScan : 하위폴더내의 @component와 @Configuration을 스캔하여 빈설정.
 */
public class Ex03AnnotationDiApplication {
	//제일먼저 실행됨
	public static void main(String[] args) {
		//스프링 컨텍스트 생성
		SpringApplication.run(Ex03AnnotationDiApplication.class, args);
	}

}
