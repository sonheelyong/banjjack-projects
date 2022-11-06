package com.green.controller;

import com.green.service.CommentService;
import com.green.vo.CommentVo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommentController {

	@Autowired
	CommentService commentService;
	@GetMapping("comment/commentList.do")
	@ResponseBody
	public List<JSONObject> getCommentList(int content_id) {
		List<JSONObject> commentList = new ArrayList<>();
		for (CommentVo cl : commentService.getCommentList(content_id)) {
			JSONObject obj = new JSONObject();
			obj.put("name", cl.getUsername());
			obj.put("commentContent", cl.getContent());
			obj.put("time", cl.getTime());
			commentList.add(obj);
		}
		return commentList;
	}
	@PostMapping ("comment/commentWrite.do")
	public void  commentWrite(HashMap<String, Object> map) {

		String userName = "Testing"; //map.get(userName);

		commentService.commentWrite(map);
	}
}

