package com.green.service.impl;

import com.green.dao.CommentDao;
import com.green.service.CommentService;
import com.green.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.HashMap;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<CommentVo> getCommentList(int content_id) {
         List<CommentVo> commentList = commentDao.getCommentList(content_id);
         return     commentList;
    }

    @Override
    public void commentUpdate(HashMap<String, Object> map) {
        commentDao.commentUpdate(map);
    }

    @Override
    public void commentDelete(HashMap<String, Object> map) {
        commentDao.commentDelete( map);
    }

    @Override
    public void commentWrite(CommentVo commentVo) {
        commentDao.commentWrite( commentVo );
    }
}
