package com.example.ny.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String Hello(Model model) {
		model.addAttribute("model", model);
		return "index";
	}

}