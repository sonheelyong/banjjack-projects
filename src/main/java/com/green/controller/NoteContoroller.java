package com.green.controller;

import com.green.service.NoteService;
import com.green.vo.NoteVo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoteContoroller {
@Autowired private NoteService noteService;

	@GetMapping("/WriteMsg")
	public String writeMsgForm() {
		return "/message";
	}

	@PostMapping("/Write")
	public String write(NoteVo vo){
		noteService.insertMsg(vo);
		return "/recepMsg";
	}



	@GetMapping("/RecepMessage")
	public String recepMsg(@RequestParam("recep") String recept){
		List<JSONObject> userVoList = new ArrayList<>();
		for (NoteVo vo : noteService.selectRecept(recept)){
			JSONObject obj = new JSONObject();
			obj.put("content", vo.getContent());
			obj.put("send", vo.getSend());
			obj.put("time", vo.getTime());
			userVoList.add(obj);
		}

		return "/recepMessage";

	}
	@RequestMapping("/SendMessage")
	public String sendMessage() {

		return "/sendMessage";

	}
	@RequestMapping("/ReadMessage")
	public String readMessage() {
		return "/readMessage";


	}
}

