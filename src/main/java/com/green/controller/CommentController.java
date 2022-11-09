package com.green.controller;

import com.green.dao.CommentDao;
import com.green.service.CommentService;
import com.green.vo.CommentVo;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

	@Autowired
	CommentService commentService;

	@Autowired
	CommentDao commentDao;

	@GetMapping("comment/commentList")
	@ResponseBody
	public List<JSONObject> getCommentList(@RequestParam int content_id) {

		List<JSONObject> commentList = new ArrayList<>();
		for (CommentVo cl : commentService.getCommentList(content_id)) {
			JSONObject obj = new JSONObject();
			obj.put("name", cl.getUsername());
			obj.put("_id", cl.get_id());
			obj.put("content", cl.getContent());
			obj.put("time", cl.getTime());
			commentList.add(obj);

		}
		return commentList;
	}

	@PostMapping("comment/writeComment")

	public void writeComment(CommentVo commentVo) {
		System.out.println("vO"+ commentVo);
		commentService.writeComment(commentVo);
//		return "comment";
	}
	@PostMapping("comment/updatecomment")

	public void commentUpdate(@RequestParam int _id, String content, String username){

		Map<String, Object>map = new HashMap<String, Object>();
		map.put("_id", _id);
		map.put("content", content);
		map.put("username", username);
		commentService.commentUpdate(map);

//		return "comment";
	}
	@PostMapping("comment/deletecomment")
	@ResponseBody
	public void commentDelete(@RequestParam int _id){

//		System.out.println(_id);

		commentService.commentDelete(_id);

	}

	@GetMapping("/comment")

	public String getComment(){
		return "comment";
	}
}

