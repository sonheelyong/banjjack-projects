package com.green.dao;

import com.green.vo.CommentVo;

import java.util.List;

public interface CommentDao {

   public List<CommentVo> getCommentList(int content_id);

   public void commentUpdate(int _id, String username);

   public void commentDelete(int _id);

   public void commentWrite(CommentVo commentVo);

}
