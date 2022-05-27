package com.goodee.movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.movie.domain.Movie;
import com.goodee.movie.service.MovieService;
import com.goodee.movie.util.SecurityUtils;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@ResponseBody
	@GetMapping(value = "/searchAllMovies", produces = "application/json; charset=UTF-8")
	public Map<String, Object> searchAllMovies() {
		Map<String, Object> map = new HashMap<>();
		List<Movie> movies = movieService.findAllMovie();
		if (movies.size() == 0) {
			map.put("message", "목록이 존재하지 않습니다.");
			map.put("movies", null);
			map.put("status", 0);
		} else {
			map.put("message", movies.size() + "개의 목록을 가져왔습니다.");
			map.put("movies", movies);
			map.put("status", 1);
		}
		return map;
	}


	@ResponseBody
    @RequestMapping(value = "/searchMovie", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public Map<String, Object> searchMovie(@RequestBody Map<String, Object> map, HttpServletRequest request) {

		Map<String, Object> result = new HashMap<>();
		SecurityUtils.XSS(request.getParameter("searchText"));
		List<Movie> movies = movieService.findMoviebyQuery(map);

		if (movies.size() == 0) {
			result.put("message", "목록이 존재하지 않습니다.");
			result.put("movies", null);
			result.put("status", 0);
		} else {
			result.put("message", movies.size() + "개의 목록을 가져왔습니다.");
			result.put("movies", movies);
			result.put("status", 1);
		}

		return result;

	}

}