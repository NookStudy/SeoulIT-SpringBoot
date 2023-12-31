package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.ITransaction1DAO;
import com.study.springboot.dao.ITransaction2DAO;

@Service
public class BuyTicketService implements IBuyTicketService{
	@Autowired
	ITransaction1DAO transaction1;
	@Autowired
	ITransaction2DAO transaction2;
	
	@Override
	public int buy(String consumerId, int amount, String error) {
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
			/*
			 	에러1이 들어오면 이 테이블에는 저장이 안됨
			 	이런 일이 생기면 안되므로 트랜잭션이 필요.
			 	transaction1부터 저장이 안되도 롤백을 해야 함.
			 */
			return 1;
			
		} catch (Exception e) {
			return 0;
		}
	}
	
	
}
