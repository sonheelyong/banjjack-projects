package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WriteController {
	
	@GetMapping("/Write")
	public String Write() {
		return "write2";
	}

}
