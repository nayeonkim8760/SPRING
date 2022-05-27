package com.goodee.movie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goodee.movie.config.DBConfig;
import com.goodee.movie.mapper.MovieMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfig.class })
public class MovieTestCase {

	@Autowired
	private MovieMapper movieMapper;

	@Test
	public void 영화목록테스트() {
		assertEquals(10, movieMapper.selectMovieList().size());
	}

}