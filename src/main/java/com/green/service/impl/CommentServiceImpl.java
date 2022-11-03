package com.green.service.impl;

import com.green.dao.CommentDao;
import com.green.service.CommentService;
import com.green.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;


    @Override
    public List<CommentVo> getCommentList(int content_id) {
        List<CommentVo> commentList = commentDao.getCommentList(content_id);
        return commentDao.getCommentList(content_id);
    }

    @Override
    public void commentEdit(CommentVo comment) {
        CommentVo vo= (CommentVo) commentDao.getCommentList(comment.get_id());
        if(!vo.getUsername().equals((comment.getUsername())));
        commentDao.updateComment(comment);

    }

    @Override
    public void commentDelete(CommentVo comment) {
        CommentVo vo= (CommentVo) commentDao.getCommentList(comment.get_id());
        if(!vo.getUsername().equals((comment.getUsername())));
        commentDao.deleteComment(comment);
    }

    @Override
    public void commentWrite(CommentVo comment) {

        commentDao.insertComment(comment);
    }
}
