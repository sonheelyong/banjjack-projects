package com.green.dao.impl;

import com.green.dao.CommentDao;
import com.green.vo.CommentVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<CommentVo> getCommentList(int content_id) {
       List<CommentVo> commentList = sqlSession.selectList("comment.commentList", content_id);
        return commentList;
    }

    @Override
    public void commentUpdate(HashMap<String, Object> map) {
        sqlSession.update("comment.commentUpdate", map);
    }

    @Override
    public void commentDelete(HashMap<String, Object> map) {

    }

    @Override
    public void commentWrite(CommentVo commentVo) {
        sqlSession.insert("comment.commentWrite", commentVo);
    }


}

