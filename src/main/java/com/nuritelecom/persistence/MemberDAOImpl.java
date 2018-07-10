
package com.nuritelecom.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nuritelecom.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);

	@Inject
	private SqlSession session;

	private static String namespace = "com.nuritelecom.mapper.MemberMapper";

	@Override
	public MemberVO read(MemberVO vo) throws Exception {
		return session.selectOne(namespace+".read", vo);
	}

	@Override
	public MemberVO checkSessionKey(String sessionKey) {
		return session.selectOne(namespace+".checkSessionKey", sessionKey);
	}

	@Override
	public void keepLogin(MemberVO vo) {
		session.selectOne(namespace+".keepLogin", vo);
	}
	
	
}
