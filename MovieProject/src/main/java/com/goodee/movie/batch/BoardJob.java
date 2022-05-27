package com.goodee.movie.batch;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.goodee.movie.mapper.MovieMapper;

@Component
public class BoardJob {

	@Autowired
	private MovieMapper movieMapper;

	@Scheduled(cron = "0/5 * * * * *")
	public void execute() {

		File file = new File("../../코미디.txt");

		System.out.println("--쿼츠 동작 중--");
		System.out.println(movieMapper);
	}

	public void save() {

		Map<String, Object> movies = new HashMap<>();
		movies.put("column", "TITLE");
		movies.put("searchText", "코미디");
		System.out.println(movieMapper.selectMovieByQuery(movies));

	}

}