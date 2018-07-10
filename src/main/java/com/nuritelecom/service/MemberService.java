package com.nuritelecom.service;

import com.nuritelecom.domain.MemberVO;

public interface MemberService {

	public MemberVO read(MemberVO vo) throws Exception;

	public MemberVO checkSessionKey(String sessionKey);

	public void keepLogin(MemberVO vo);


}
