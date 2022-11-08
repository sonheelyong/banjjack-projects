package com.green.controller;

import com.green.dao.CommentDao;
import com.green.service.CommentService;
import com.green.vo.CommentVo;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
//		System.out.println(content_id);
//		List<CommentVo> commentList = new ArrayList<>();
//		for(CommentVo cv : commentDao.getCommentList(content_id)){
//			commentList.add(cv);
//		}
//
		List<JSONObject> commentList = new ArrayList<>();
		for (CommentVo cl : commentService.getCommentList(content_id)) {
			JSONObject obj = new JSONObject();
			obj.put("name", cl.getUsername());
			obj.put("content", cl.getContent());
			obj.put("time", cl.getTime());
			commentList.add(obj);

		}
		return commentList;
	}

	@GetMapping("comment/writecomment")
	@ResponseBody
	public String commentWrite(CommentVo commentVo) {


		commentService.commentWrite(commentVo);
		
		return null;
	}
	@GetMapping("comment/updatecomment")
	@ResponseBody
	public String commentUpdate(@RequestParam int _id, String content, String username){
		System.out.println(_id);
		System.out.println(content);
		System.out.println(username);
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("_id", _id);
		map.put("content", content);
		map.put("username", username);
		commentService.commentUpdate(map);

		return null;
	}
	@GetMapping("comment/deletecomment")
	@ResponseBody
	public String commentDelete(@RequestParam int _id){

		System.out.println(_id);

		commentService.commentDelete(_id);

		return null;
	}

	@GetMapping("/comment")
	public String getComment(){
		return "comment";
	}
}

