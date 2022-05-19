package com.goodee.practice.service;

import java.util.List;

import com.goodee.practice.domain.BoardDTO;

public interface BoardService {

	public List<BoardDTO> findBoards();

	public BoardDTO findBoardByNo(long no);

	public int insert(BoardDTO board);
	
	public void increaseHit(long no);

	public int modify(BoardDTO board);

	public int remove(long no);
}