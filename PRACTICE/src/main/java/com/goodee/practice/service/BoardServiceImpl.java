package com.goodee.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.goodee.practice.domain.BoardDTO;
import com.goodee.practice.repository.BoardRepository;

public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Override
	public List<BoardDTO> findBoards() {
		return boardRepository.selectBoards();
	}

	@Override
	public BoardDTO findBoardByNo(long no) {
		return boardRepository.selectBoardByNo(no);
	}

	@Override
	public void increaseHit(long no) {
		boardRepository.updateHit(no);
	}

	@Override
	public int insert(BoardDTO board) {
		return boardRepository.insertBoard(board);
	}

	@Override
	public int modify(BoardDTO board) {
		return boardRepository.modifyBoard(board);
	}

	@Override
	public int remove(long no) {
		return boardRepository.removeBoard(no);
	}

}