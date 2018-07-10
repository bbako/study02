package com.nuritelecom.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.nuritelecom.domain.BoardVO;
import com.nuritelecom.domain.FileVO;
import com.nuritelecom.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;

	@Override
	public void regist(BoardVO board, MultipartHttpServletRequest request) throws Exception {
		dao.create(board,request);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		dao.update(board);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll(int page) throws Exception {
		return dao.listAll(page);
	}

	@Override
	public int total() {
		return dao.total();
	}
	@Override
	public int insertFile(FileVO vo) {
		return dao.insertFile(vo);
	}

}
