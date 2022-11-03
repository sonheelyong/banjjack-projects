package com.green.controller;

import com.green.service.CommentService;
import com.green.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommentController {

	@Autowired
	CommentService commentService;
	@GetMapping("comment/commentList.do")
	public Map<String, Object> commentList(int content_id){
		List<CommentVo> commentList=commentService.getCommentList(content_id);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("data", commentList);
		return map;

	}
	@PostMapping ("comment/commentWrite.do")
	public Map<String, Object> commentWrite(CommentVo comment){
		System.out.println(comment);
		commentService.commentWrite(comment);

		Map<String, Object> map=new HashMap<String, Object>();
		map.put("result", true);
		map.put("msg", "등록했습니다");
		return map;

	}
	@PostMapping("comment/commentEdit.do")
	public Map<String, Object> commentEdit(CommentVo comment){
		Map<String, Object> map=new HashMap<String, Object>();
		commentService.commentEdit(comment);
		map.put("result",true);
		map.put("msg", "수정완료");
		return map;
	}
	@PostMapping("comment/commentDelete.do")
	public Map<String, Object> commentDelete(CommentVo comment) {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}
}

