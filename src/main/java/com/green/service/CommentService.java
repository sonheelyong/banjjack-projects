package com.green.service;

import com.green.dao.CommentDao;
import com.green.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CommentService")
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public List<CommentVo> getCommentList(int content_id) {
        List<CommentVo> commentList = commentDao.getCommentList(content_id);
        return     commentList;
    }
    public void commentUpdate(int _id, String username) {

        commentDao.commentUpdate(_id, username);
    }
    public void commentDelete(int _id) {

        commentDao.commentDelete( _id);
    }
    public void commentWrite(CommentVo commentVo) {
        commentDao.commentWrite( commentVo );
    }
}
