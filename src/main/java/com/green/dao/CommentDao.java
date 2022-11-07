package com.green.dao;

import com.green.vo.CommentVo;

import java.util.HashMap;
import java.util.List;

public interface CommentDao {

   public List<CommentVo> getCommentList(int content_id);

   public void commentUpdate(CommentVo commentVo);

   public void commentDelete(CommentVo commentVo);

   public void commentWrite(CommentVo commentVo);

}
