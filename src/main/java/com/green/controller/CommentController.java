package com.green.controller;

import com.green.service.CommentService;
import com.green.vo.CommentSearchVo;
import com.green.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommentController {
	@GetMapping("comment/commentList.wow")
	public Map<String, Object> commentList(CommentSearchVo searchVo){
		List<CommentVo> commentList=CommentService.getCommentListByParent(searchVo);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("result", true);
		map.put("data", commentList);
		map.put("size", commentList.size());
		return map;

	}
	@PostMapping ("comment/commentWrite.wow")
	public Map<String, Object> commentWrite(CommentVo comment){
		System.out.println(comment);
		CommentService.commentWrite(comment);

		Map<String, Object> map=new HashMap<String, Object>();
		map.put("result", true);
		map.put("msg", "등록했습니다");
		return map;

	}
	@PostMapping("comment/commentEdit.wow")
	public Map<String, Object> commentEdit(CommentVo comment){
		Map<String, Object> map=new HashMap<String, Object>();
		CommentService.commentEdit(comment);
		map.put("result",true);
		map.put("msg", "수정완료");
		return map;
	}
	@PostMapping("comment/commentDelete.wow")
	public Map<String, Object> commentDelete(CommentVo comment) {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}
}

