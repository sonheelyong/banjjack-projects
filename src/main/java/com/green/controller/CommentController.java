package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommentController {
	
	@GetMapping("/reply")
	public String getReply() {
		return "comment";
	}

}
