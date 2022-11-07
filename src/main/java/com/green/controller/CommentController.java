package com.green.controller;

import com.green.dao.CommentDao;
import com.green.service.CommentService;
import com.green.vo.CommentVo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
			obj.put("_id", cl.get_id());
			obj.put("name", cl.getUsername());
			obj.put("content", cl.getContent());
			obj.put("time", cl.getTime());
			commentList.add(obj);

		}
		return commentList;
	}

	@GetMapping("comment/writecomment")
	public void commentWrite(CommentVo commentVo) {

		System.out.println(commentVo);
		commentService.commentWrite(commentVo);
	}
	@GetMapping("comment/updatecomment")
	public void commentUpdate(@RequestParam int _id, String username){
		System.out.println(_id);
		System.out.println(username);
		commentService.commentUpdate(_id, username);
		System.out.println("수정완료");

	}
	@GetMapping("comment/deletecomment")
	@ResponseBody
	public void commentDelete(@RequestParam int _id){


		commentService.commentDelete(_id);
		System.out.println("삭제완료");

	}

	@GetMapping("/comment")
	public String getComment(){
		return "comment";
	}
}

