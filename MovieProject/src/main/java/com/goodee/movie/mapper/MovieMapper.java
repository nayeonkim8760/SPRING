package com.goodee.movie.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.movie.domain.Movie;

@Mapper
public interface MovieMapper {

	public List<Movie> selectMovieList();

	public List<Movie> selectMovieByQuery(Map<String, Object> map);
	
}