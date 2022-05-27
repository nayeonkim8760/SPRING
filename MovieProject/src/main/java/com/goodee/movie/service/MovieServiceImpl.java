package com.goodee.movie.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.movie.domain.Movie;
import com.goodee.movie.mapper.MovieMapper;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;

	@Override
	public List<Movie> findAllMovie() {
		return movieMapper.selectMovieList();
	}

	@Override
	public List<Movie> findMoviebyQuery(Map<String, Object> map) {
		return movieMapper.selectMovieByQuery(map);
	}
}