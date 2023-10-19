package com.study.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Memberepository extends JpaRepository<Member, Long>{
	//제네릭 타입 : long 이 아니라 Long
	//기본적인 Create,Read,Update,Delete(CRUD) 자동작성
	
	//findby 뒤에 컬럼명을 붙여주면 이를 이용한 검색이 가능.
	Optional<Member> findByName(String keyword);
	Optional<Member> findByEmail(String keyword);
	
	//다양한 확장가능
	List<Member> findByNameLike(String keyword);
	List<Member> findByNameLikeOrderByNameDesc(String keyword);
	List<Member> findByNameLikeOrderByNameAscEmailDesc(String keyword);
	
	List<Member> findByNameLike(String keyword, Sort sort);
}
