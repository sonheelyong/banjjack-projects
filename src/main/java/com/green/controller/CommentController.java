package com.green.controller;

import com.green.service.CommentService;
import com.green.vo.CommentVo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommentController {

	@Autowired
	CommentService commentService;
	@PostMapping("comment/commentList.do")
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
	public void commentWrite(CommentVo commentVo) {
		String userName = "Testing";
		commentVo.setUsername(userName);
		commentService.commentWrite(commentVo);



	}
}

