package com.example.firstbootapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstMvcController {

	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "First MVC Controller";
	}
}
