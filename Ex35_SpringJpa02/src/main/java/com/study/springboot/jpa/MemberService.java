package com.study.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private Memberepository memberRepository;
	
	public void insert() {
		Member member;
		
		member = Member.builder().name("이순신").email("test1@test.com").build();
		memberRepository.save(member);
		
		member = Member.builder().name("강감찬").email("test2@test.com").build();
		memberRepository.save(member);
		
		member = Member.builder().name("을지문덕").email("test3@test.com").build();
		memberRepository.save(member);
		
		member = Member.builder().name("계백").email("test4@test.com").build();
		memberRepository.save(member);
		
		member = Member.builder().name("김유신").email("test5@test.com").build();
		memberRepository.save(member);
		
		member = Member.builder().name("연개소문").email("tes61@test.com").build();
		memberRepository.save(member);
		
		member = Member.builder().name("양만춘").email("test7@test.com").build();
		memberRepository.save(member);
		
		member = Member.builder().name("김종서").email("test8@test.com").build();
		memberRepository.save(member);
		
		member = Member.builder().name("최영").email("test9@test.com").build();
		memberRepository.save(member);
		
		member = Member.builder().name("이금").email("test11@test.com").build();
		memberRepository.save(member);
		
		member = Member.builder().name("이신").email("test12@test.com").build();
		memberRepository.save(member);
	}
	
	public Optional<Member> select(Long id){
		Optional<Member> member = memberRepository.findById(id);
		return member;
	}
	
	public List<Member> selectall(){
		return memberRepository.findAll();
	}
	
	public Optional<Member> selectId(Long search){
		Optional<Member> member = memberRepository.findById(search);
		return member;
	}
	
	public Optional<Member> selectName(String search){
		Optional<Member> member = memberRepository.findByName(search);
		return member;
	}
	
	public Optional<Member> selectEmail(String search){
		Optional<Member> member = memberRepository.findByEmail(search);
		return member;
	}
	
	public List<Member> selectNameLike(String search){
		List<Member> member = memberRepository.findByNameLike(search);
		return member;
	}
	
	public List<Member> selectNameLikeNameDesc(String search){
		List<Member> member = memberRepository.findByNameLikeOrderByNameDesc(search);
		return member;
	}
	
	public List<Member> selectNameLike(String search, Sort sort){
		List<Member> member = memberRepository.findByNameLike(search,sort);
		return member;
	}
	
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	
	public Member update(Member member) {
		//insert와 같음.
		//키값과 같은값이 있으면 업데이트, 없으면 인서트
		Member returnMember = memberRepository.save(member);
		return returnMember;
	}
}
