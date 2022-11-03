package com.green.dao;

import com.green.vo.CommentSearchVo;
import com.green.vo.CommentVo;

import java.util.List;

public interface CommentDao {
   public int getCommentCountByParenent(CommentSearchVo SearchVo);

   public List<CommentVo> getCommentListByParent(CommentSearchVo commentVo);

   public int updateComment(CommentVo comment);

   public int deleteComment(CommentVo comment);

   public int insertComment(CommentVo comment);

}
