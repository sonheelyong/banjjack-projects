package com.green.service;

import com.green.vo.CommentSearchVo;
import com.green.vo.CommentVo;

import java.util.List;

public interface CommentService {

    public List<CommentVo> getCommentListByParent(CommentSearchVo searchVo);

    public void commentEdit(CommentVo comment) ;

    public void commentDelete(CommentVo comment) ;

    public void commentWrite(CommentVo comment) ;

}
