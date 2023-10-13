package com.study.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.ISimpleBbsDAO;
import com.study.springboot.dto.SimpleBbsDTO;

@Service
public class SimpleBbsService implements ISimpleBbsService{
	
	@Autowired
	ISimpleBbsDAO dao;

	@Override
	public List<SimpleBbsDTO> list() {
		return dao.listDAO();
	}
	//지금은 한개만 있지만 여러개의 DAO가 있을때 한번에 엮어서 가져올수 있음
	@Override
	public SimpleBbsDTO view(String id) {
		// TODO Auto-generated method stub
		return dao.viewDAO(id);
	}

	@Override
	public int write(Map<String, String> map) {
		int nResult = dao.writeDAO(map);
		return nResult;
	}

	@Override
	public int delete(String id) {
		int nResult = dao.deleteDAO(id);
		return nResult;
	}

	@Override
	public int count() {
		int nTotalCount = dao.articleCount();
		return nTotalCount;
	}

	
}
