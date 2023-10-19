package com.study.springboot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Memberepository extends JpaRepository<Member, Long>{
	//제네릭 타입 : long 이 아니라 Long
	//기본적인 Create,Read,Update,Delete(CRUD) 자동작성
}
