package com.study.springboot.dto;

import java.lang.reflect.Member;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FreeBoard")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreeBoard {
	@Id
	private Long Freeno;
	@ManyToAny
	@JoinColumn(name="no")
	private Member member;
	private String title;
	private String content;
}
