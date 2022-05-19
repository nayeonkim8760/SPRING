package com.example.ny;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.ny.config.BoardConfig;
import com.example.ny.config.DBConfig;
import com.example.ny.domain.BoardDTO;
import com.example.ny.service.BoardService;

@ContextConfiguration(classes = { BoardConfig.class, DBConfig.class })

@SpringBootTest
class NyApplicationTests {

	@Autowired
	private BoardService boardService;

	@Test
	void contextLoads() {
		BoardDTO board = new BoardDTO(0, "TEST", "TEST", "TEST", "2022-05-20", "2022-05-20");
		boardService.save(board);
	}

}