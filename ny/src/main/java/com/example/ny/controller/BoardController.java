package com.example.ny.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ny.domain.BoardDTO;
import com.example.ny.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api
public class BoardController {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	@ApiOperation(value = "게시글 전체 조회", notes = "게시글을 전체 조회한다.")
	@GetMapping("/list")
	@ResponseBody
	public String list(Model model) {
		List<BoardDTO> boards = boardService.findBoards();
		logger.info("list() : " + boards);
		model.addAttribute("boards", boards);
		return "list";
	}

	@ApiOperation(value = "게시글 상세 조회", notes = "게시글을 상세 조회한다.")
	@GetMapping(value = "/detail")
	@ResponseBody
	public String detail(@ApiParam(value = "no", required = true, defaultValue = "0") long no, Model model) {
		BoardDTO board = boardService.findBoardByNo(no);
		logger.info("detail() : " + board);
		model.addAttribute("board", board);
		return "detail";
	}

	@GetMapping("/addPage")
	public String addPage() {
		return "/add";
	}

	@ApiOperation(value = "게시글 작성", notes = "게시글을 추가한다.")
	@PostMapping("/add")
	@ResponseBody
	public String add(BoardDTO board) {
		logger.info("add() : " + board);
		boardService.save(board);
		return "redirect:/list";
	}

	@ApiOperation(value = "게시글 삭제", notes = "게시글을 삭제한다.")
	@GetMapping("/remove")
	@ResponseBody
	public String remove(@ApiParam(value = "no", required = true, defaultValue = "0") long no) {
		logger.info("remove() : " + no);
		boardService.remove(no);
		return "redirect:/list";
	}

	@GetMapping("/modifyPage")
	public String modifyPage(@ApiParam(value = "no", required = true, defaultValue = "0") long no, Model model) {
		logger.info("modifyPage()" + no);
		model.addAttribute("board", boardService.findBoardByNo(no));
		return "modify";
	}

	@ApiOperation(value = "게시글 수정", notes = "게시글을 수정한다.")
	@PostMapping("/modify")
	@ResponseBody
	public String modify(BoardDTO board) {
		logger.info("modify() : " + board);
		boardService.modify(board);
		return "redirect:/detail?no=" + board.getNo();
	}
}