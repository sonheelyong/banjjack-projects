package com.green.dao;

import com.green.vo.CommentVo;

import java.util.List;

public interface CommentDao {

   public List<CommentVo> getCommentList(int content_id);

   public int updateComment(CommentVo comment);

   public int deleteComment(CommentVo comment);

   public int insertComment(CommentVo comment);

}
