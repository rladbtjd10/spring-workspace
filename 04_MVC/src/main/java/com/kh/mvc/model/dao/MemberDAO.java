package com.kh.mvc.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired //getsession �ߴ��Ŷ� ������
	private SqlSessionTemplate sqlSession;
	
//	public int registerMember(Member vo) {
//		return sqlSession.insert("memberMapper.registerMember", vo);
//	}
	
	/*
	 * showAllMember
	 * findMember -> �Ķ���� : String keyword, return : List<Member>
	 * login -> �Ķ���� : Member vo
	 * updateMember -> �Ķ���� : Member vo
	 * 
	 */

}
