package com.goodee.movie.service;

import java.util.List;
import java.util.Map;

import com.goodee.movie.domain.Movie;

public interface MovieService {

	public List<Movie> findAllMovie();

	public List<Movie> findMoviebyQuery(Map<String, Object> map);

}