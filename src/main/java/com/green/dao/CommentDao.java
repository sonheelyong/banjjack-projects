package com.green.dao;

import com.green.vo.CommentVo;

import java.util.List;
import java.util.Map;

public interface CommentDao {

   public List<CommentVo> getCommentList(int content_id);

   public void commentUpdate(Map<String, Object> map);

   public void commentDelete(int _id);

   public void writeComment(CommentVo commentVo);

}
