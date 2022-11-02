package com.green.controller;

import com.green.service.MsgService;
import com.green.vo.MsgVo;
import com.green.vo.UserVo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MsgContoroller {
@Autowired private MsgService msgService;

	@GetMapping("/WriteMsg")
	public String writeMsgForm() {
		return "/message";
	}

	@PostMapping("/Write")
	public String write(MsgVo vo){
		msgService.insertMsg(vo);
		return "/recepMsg";
	}



	@GetMapping("/RecepMessage")
	public String recepMsg(@RequestParam("recep") String recept){
		List<JSONObject> userVoList = new ArrayList<>();
		for (MsgVo vo : msgService.selectRecept(recept)){
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

