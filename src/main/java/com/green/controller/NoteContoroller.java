package com.green.controller;

import com.green.service.NoteService;
import com.green.vo.NoteVo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NoteContoroller {
@Autowired private NoteService noteService;

	@RequestMapping ("/writeNoteForm")
	public String writeMsgForm() {
		return "/writeNote";
	}

	@RequestMapping(value = "/writenote", method = RequestMethod.POST )
	public String write(HttpServletRequest request){
		NoteVo noteVo = new NoteVo();
		noteVo.setContent(request.getParameter("content"));
		noteVo.setSend(request.getParameter("send"));
		noteVo.setRecept(request.getParameter("recept"));
		System.out.println(noteVo.toString());
		noteService.insertNote(noteVo);
		return "/receptNote";
	}


	@GetMapping("/getrecenote")
	@ResponseBody
	public  List<JSONObject> getrecepnote(@RequestParam String recept){
		List<JSONObject> NoteVoList = new ArrayList<>();
		for (NoteVo vo : noteService.selectRecept(recept)){
			JSONObject obj = new JSONObject();
			obj.put("_id", vo.get_id());
			obj.put("content", vo.getContent());
			obj.put("send", vo.getSend());
			obj.put("time", vo.getTime());
			NoteVoList.add(obj);
		}

		return NoteVoList;

	}
	@RequestMapping("/receptNote")
	public String recepte(){
		return "/receptNote";
	}


	@GetMapping("/getsendNote")
	@ResponseBody
	public  List<JSONObject> getsendNote(@RequestParam String send) {
		List<JSONObject> NoteVoList = new ArrayList<>();
		for (NoteVo vo : noteService.selectRecept(send)) {
			JSONObject obj = new JSONObject();
			obj.put("_id", vo.get_id());
			obj.put("content", vo.getContent());
			obj.put("recept", vo.getRecept());
			obj.put("time", vo.getTime());
			NoteVoList.add(obj);
		}
		return NoteVoList;
	}

	@RequestMapping("/readNote")
	public String sendMessage() {

		return "/readDetailNote";

	}
}

