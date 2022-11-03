package com.green.dao.impl;

import com.green.dao.CommentDao;
import com.green.vo.CommentVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SqlSession sqlsession;
    @Override
    public List<CommentVo> list(Integer _id) {
        return sqlsession.selectList("Comment.listcomment", _id);
    }

    @Override
    public void write(CommentVo vo) {
        sqlsession.insert("Comment.insertComment", vo);

    }

    @Override
    public void update(CommentVo vo) {
        sqlsession.update("Comment.updateComment", vo);
    }

    @Override
    public void delete(Integer content_id) {

    }
}

