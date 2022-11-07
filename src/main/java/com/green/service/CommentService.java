package com.green.service;

import com.green.dao.CommentDao;
import com.green.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("CommentService")
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public List<CommentVo> getCommentList(int content_id) {
        List<CommentVo> commentList = commentDao.getCommentList(content_id);
        return     commentList;
    }
    public void commentUpdate(CommentVo commentVo) {

        commentDao.commentUpdate(commentVo);
    }
    public void commentDelete(CommentVo commentVo) {
        commentDao.commentDelete( commentVo);
    }
    public void commentWrite(CommentVo commentVo) {
        commentDao.commentWrite( commentVo );
    }
}
