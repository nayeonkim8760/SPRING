package com.goodee.practice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodee.practice.domain.BoardDTO;
import com.goodee.practice.service.BoardService;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("list")
	public String list(Model model) {
		List<BoardDTO> boards = boardService.findBoards();
		logger.info("list() : " + boards);
		model.addAttribute("boards", boards);
		return "list";
	}

	@GetMapping("addPage")
	public String addPage() {
		return "add";
	}

	@PostMapping("add")
	public String add(BoardDTO board) {
		logger.info("add() : " + board);
		boardService.insert(board);
		return "redirect:list";
	}

	@GetMapping("remove")
	public String remove(@RequestParam(value = "no", required = false, defaultValue = "0") long no) {
		logger.info("remove() : " + no);
		boardService.remove(no);
		return "redirect:list";
	}

	@GetMapping("modifyPage")
	public String modifyPage() {
		return "modify";
	}

	@GetMapping("modify")
	public String modify(@RequestParam(value = "no", required = false, defaultValue = "0") long no, Model model) {
		boardService.increaseHit(no);
		BoardDTO board = new BoardDTO();
		logger.info("modify() : " + board);
		model.addAttribute("board", board);
		return "modify";
	}
}