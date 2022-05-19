package com.example.ny.config;

import org.springframework.context.annotation.Bean;

import com.example.ny.repository.BoardRepository;
import com.example.ny.service.BoardService;
import com.example.ny.service.BoardServiceImpl;

public class BoardConfig {

	@Bean
	public BoardService boardService() {
		return new BoardServiceImpl();
	}

	@Bean
	public BoardRepository boardRepository() {
		return new BoardRepository();
	}
}