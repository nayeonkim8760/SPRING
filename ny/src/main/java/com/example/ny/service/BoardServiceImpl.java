package com.example.ny.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ny.domain.BoardDTO;
import com.example.ny.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository boardRepository;

	@Override
	public List<BoardDTO> findBoards() {

		return boardRepository.selectBoardList();
	}

	@Override
	public BoardDTO findBoardByNo(long no) {

		return boardRepository.selectBoardByNo(no);
	}

	@Override
	public void save(BoardDTO board) {

		boardRepository.insertBoard(board);

	}

	@Override
	public void modify(BoardDTO board) {

		boardRepository.updateBoard(board);

	}

	@Override
	public void remove(long no) {

		boardRepository.removeBoard(no);

	}

}