package com.study.springboot.dto;

import lombok.Data;

//회계장부
@Data
public class Transaction2DTO {
	private String consumerId;
	private int amount;
}
