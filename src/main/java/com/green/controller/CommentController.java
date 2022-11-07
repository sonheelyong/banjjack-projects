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
			obj.put("name", cl.getUsername());
			obj.put("content", cl.getContent());
			obj.put("time", cl.getTime());
			commentList.add(obj);

		}
		return commentList;
	}

	@PostMapping("comment/commenWrite")
	public Map<String, Object> commentWrite(CommentVo commentVo) {


		commentService.commentWrite(commentVo);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("msg", "댓글을 등록했습니다!");
		return map;
	}
	@PostMapping("comment/commentUpdate")
	public Map<String, Object> commentUpdate(CommentVo commentVo){

		commentService.commentUpdate(commentVo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "댓글을 수정했습니다!");
		return map;
	}
	@PostMapping("comment/commentDelete")
	public Map<String, Object> commentDelete(CommentVo commentVo){

		commentService.commentDelete(commentVo);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("msg", "댓글을 삭제했습니다!");
		return map;
	}

	@GetMapping("/comment")
	public String getComment(){
		return "comment";
	}
}

