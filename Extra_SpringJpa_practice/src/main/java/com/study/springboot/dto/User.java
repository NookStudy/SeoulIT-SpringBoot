package com.study.springboot.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@SequenceGenerator(
			name = "User_SEQ_GEN",
			sequenceName = "User_SEQ",
			initialValue = 1,
			allocationSize = 1
	)
	@GeneratedValue(generator = "User_SEQ_GEN")
	private Long no;
	private String username;
    private String password;
    private String email;
    private String role;
	
}
