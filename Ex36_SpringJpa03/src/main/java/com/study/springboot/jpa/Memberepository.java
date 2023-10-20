package com.study.springboot.jpa;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Memberepository extends JpaRepository<Member, Long>{

	Page<Member> findByNameLike(String keyword,Pageable pageable);
}
