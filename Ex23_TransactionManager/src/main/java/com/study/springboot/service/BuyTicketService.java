package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.study.springboot.dao.ITransaction1DAO;
import com.study.springboot.dao.ITransaction2DAO;

@Service
public class BuyTicketService implements IBuyTicketService{
	//JDBC 연동을 위한 자동주입
	@Autowired
	ITransaction1DAO transaction1;
	@Autowired
	ITransaction2DAO transaction2;
	
	//트랜잭션 처리를 위한 자동주입
	@Autowired	//스프링 기본제공 플랫폼트랜잭션매니저
	PlatformTransactionManager transactionManager;
	@Autowired
	TransactionDefinition definition;
	
	@Override
	public int buy(String consumerId, int amount, String error) {
		
		TransactionStatus status = transactionManager.getTransaction(definition);
		/*
		  	상황 : 현장에서는 표가 발행되었는데 전산에 등록이 안될때..
		 */
		try {
			//DAO 변수인 transaction1 pay()를 호출
			transaction1.pay(consumerId, amount);
			
			//의도적 에러 발생
			if (error.equals("1")) {
				int n = 10/0;
			}
			transaction2.pay(consumerId, amount);
			
			//롤백시킬곳 위치 저장
			transactionManager.commit(status);
			return 1;
			
		} catch (Exception e) {
			System.out.println("[PlatformTransactionManager] Rollback");
			//서버에 commit(status)위치로 롤백 전달
			transactionManager.rollback(status);
			return 0;
		}
	}
	
	
}
