package com.goodee.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.goodee.practice.repository.BoardRepository;
import com.goodee.practice.service.BoardService;
import com.goodee.practice.service.BoardServiceImpl;

@Configuration
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