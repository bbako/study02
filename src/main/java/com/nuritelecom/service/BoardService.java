package com.nuritelecom.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.nuritelecom.domain.BoardVO;
import com.nuritelecom.domain.FileVO;

public interface BoardService {

	public void regist(BoardVO board, MultipartHttpServletRequest request) throws Exception;

	public BoardVO read(Integer bno) throws Exception;

	public void modify(BoardVO board) throws Exception;

	public void remove(Integer bno) throws Exception;

	public List<BoardVO> listAll(int page) throws Exception;

	public int total();
	
	public int insertFile(FileVO vo);
	

}
