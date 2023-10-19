package com.study.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private Memberepository memberRepository;
	
	public Member insert(Member member) {
		Member returnMember = memberRepository.save(member);
		return returnMember;
	}
	
	public Optional<Member> select(Long id){
		Optional<Member> member = memberRepository.findById(id);
		return member;
	}
	
	public List<Member> selectall(){
		return memberRepository.findAll();
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
