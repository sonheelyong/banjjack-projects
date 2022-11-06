package com.green.dao;

import com.green.vo.CommentVo;

import java.util.HashMap;
import java.util.List;

public interface CommentDao {

   public List<CommentVo> getCommentList(int content_id);

   public void commentUpdate(HashMap<String, Object> map);

   public void commentDelete(HashMap<String, Object> map);

   public void commentWrite(HashMap<String, Object> map);

}
