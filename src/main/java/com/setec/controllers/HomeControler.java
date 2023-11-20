package com.setec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControler {
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
