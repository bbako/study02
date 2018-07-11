package com.nuritelecom.persistence;

import com.nuritelecom.domain.MemberVO;

public interface MemberDAO {

	public MemberVO read(MemberVO vo) throws Exception;

	public MemberVO checkSessionKey(String sessionKey);

	public void keepLogin(MemberVO vo);

    MemberVO login(MemberVO dto);
}
