package com.example.ny.service;

import java.util.List;

import com.example.ny.domain.BoardDTO;


public interface BoardService {

	public List<BoardDTO> findBoards();
	public BoardDTO findBoardByNo(long no);
	public void save(BoardDTO board);
	public void modify(BoardDTO board);
	public void remove(long no);

}