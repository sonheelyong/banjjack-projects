package com.green.controller;

import com.green.service.CommentService;
import com.green.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
@RequestMapping("/Comment")
public class CommentController {
	@Autowired
	CommentService commentService;

	//댓글쓰기
	@PostMapping("/write")

	public void write(@ModelAttribute CommentVo vo)
	{
//		String username = (String) session.getAttribute("username");
//		vo.setUsername(username);
		commentService.write(vo);

	}
	//List출력
	@GetMapping("/List")
	public ModelAndView list(@RequestParam int _id, ModelAndView mav){
		List<CommentVo> list = commentService.list(_id);
		mav.setViewName("/CommentList");
		mav.addObject("list", list);
		return mav;
	}
	//JSON 변환?
	@GetMapping("/listJson")
	@ResponseBody
	public List<CommentVo> listJson(@RequestParam int _id){
		return commentService.list(_id);
	}
}

