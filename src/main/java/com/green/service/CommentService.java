package com.green.service;

import com.green.vo.CommentVo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


public interface CommentService {

    public List<CommentVo> getCommentList(int content_id );

    public void commentUpdate(HashMap<String, Object> map) ;

    public void commentDelete(HashMap<String, Object> map) ;

    public void commentWrite(HashMap<String, Object> map) ;

}
