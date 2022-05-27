package com.goodee.movie.config;

import org.springframework.beans.factory.annotation.Autowired;

import com.goodee.movie.service.MovieService;
import com.goodee.movie.service.MovieServiceImpl;

public class MovieConfig {

	@Autowired
	public MovieService movieService() {
		return new MovieServiceImpl();
	}

}