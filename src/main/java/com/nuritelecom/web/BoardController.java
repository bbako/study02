package com.nuritelecom.web;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nuritelecom.domain.BoardVO;
import com.nuritelecom.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService service;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void indexGet(BoardVO board, Model model) throws Exception {
		logger.info("hi!!!!");
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGet(BoardVO board, Model model) throws Exception {

		logger.info("regi......get");
	}

	@RequestMapping(value = "/register2", method = RequestMethod.GET)
	public void registerGet2(BoardVO board, Model model) throws Exception {
		logger.info("regi2......get");
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public void success(BoardVO board, Model model) throws Exception {
		logger.info("success......get");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(BoardVO board, Model model) throws Exception {

		logger.info("regi......post");
		logger.info(board.toString());
		service.regist(board);
		model.addAttribute("result", "success");
		return "board/success";
	}
	
	@GetMapping("/listAll")
	public void listAll(Model model) throws Exception {
		
		logger.info("listAll get");
		model.addAttribute("list", service.listAll());
		
	}
	@GetMapping("/read")
	public void read(int bno,Model model) throws Exception {
		
		logger.info("read one");
		
		model.addAttribute("one", service.read(bno));
		
	}
	
	@GetMapping("/modify")
	public void modify(BoardVO vo,Model model) throws Exception {
		
		logger.info("modify one");
		
		model.addAttribute("one", service.read(vo.getBno()));
		
	}
	
	@PostMapping("/modify")
	public String modifyPost(BoardVO vo,Model model) throws Exception {
		
		logger.info("modify post");
		logger.info(vo.toString());
		
		//model.addAttribute("one", service.read(vo.getBno()));
		
		service.modify(vo);
		
		return "redirect:/board/listAll";
	}
	
	

}
