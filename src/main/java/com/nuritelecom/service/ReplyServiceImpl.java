package com.nuritelecom.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.nuritelecom.domain.ReplyVO;
import com.nuritelecom.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO dao;

	@Override
	public void regist(ReplyVO board) throws Exception {
		dao.create(board);
	}

	@Override
	public void modify(ReplyVO board) throws Exception {
		dao.update(board);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<ReplyVO> listAll(Integer bno) throws Exception {
		return dao.listAll(bno);
	}

}
