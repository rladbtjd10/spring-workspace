package com.kh.api.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.api.model.Phone;
import com.kh.api.model.UserInfo;

@Repository
public class PhoneDAOImpl implements PhoneDAO {
	
	private final SqlSession sqlSession;
	
	@Autowired
    public PhoneDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

	@Override
	public int insert(Phone phone) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Phone phone) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Phone select(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phone> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo select(UserInfo user) {
		// TODO Auto-generated method stub
		return null;
	}



}
