package com.green.dao.impl;

import com.green.dao.CommentDao;
import com.green.vo.CommentSearchVo;
import com.green.vo.CommentVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {


    @Override
    public int getCommentCountByParenent(CommentSearchVo SearchVo) {
        return 0;
    }

    @Override
    public List<CommentVo> getCommentListByParent(CommentSearchVo commentVo) {
        return null;
    }

    @Override
    public int updateComment(CommentVo comment) {
        return 0;
    }

    @Override
    public int deleteComment(CommentVo comment) {
        return 0;
    }

    @Override
    public int insertComment(CommentVo comment) {
        return 0;
    }
}

