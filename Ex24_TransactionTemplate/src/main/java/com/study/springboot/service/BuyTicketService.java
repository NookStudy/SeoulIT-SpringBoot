package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

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
//	@Autowired	//스프링 기본제공 플랫폼트랜잭션매니저
//	PlatformTransactionManager transactionManager;
//	@Autowired
//	TransactionDefinition definition;
	
	//트랜잭션 빈 자동 주입
	@Autowired
	TransactionTemplate transactionTemplate; 
	
	@Override
	public int buy(String consumerId, int amount, String error) {
		
//		TransactionStatus status = transactionManager.getTransaction(definition);
		/*
		  	상황 : 현장에서는 표가 발행되었는데 전산에 등록이 안될때..
		 */
		try {
			//트랜잭션 탬플릿을 통해 DB처리와 비즈니스 로직을 실행한다.
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				
				//익명 클래스의 오버라이딩 된 메서드 안으로 모든 로직을 옮겨준다.
				//또한 템플릿을 사용하면 commit, rollback이 자동으로 처리된다.
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus arg0) {
					//DAO 변수인 transaction1 pay()를 호출
					
					/*
					 	비지니스 로직 : 두개 다 성고하면 커밋, 1개라도 에러면 롤백
					 	이렇게 붙어 있어서 자도응로 커밋,롤백이 되어 코딩이 편리함.
					 	그래서 이방법을 더 선호한다.
					 */
					transaction1.pay(consumerId, amount);
					
					//의도적 에러 발생
					if (error.equals("1")) {
						int n = 10/0;
					}
					transaction2.pay(consumerId, amount);
					
				}
			});
			
			
			//롤백시킬곳 위치 저장
//			transactionManager.commit(status);
			return 1;
			
		} catch (Exception e) {
			System.out.println("[PlatformTransactionManager] Rollback");
			//서버에 commit(status)위치로 롤백 전달
//			transactionManager.rollback(status);
			return 0;
		}
	}
	
	
}
