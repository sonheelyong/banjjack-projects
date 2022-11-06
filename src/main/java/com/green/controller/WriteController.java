package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WriteController {
	
	@GetMapping("/write")
	public String Write() {
		return "write";
	}

}
