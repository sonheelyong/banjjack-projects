package com.green.service.impl;

import com.green.dao.CommentDao;
import com.green.service.CommentService;
import com.green.vo.CommentSearchVo;
import com.green.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {


    @Override
    public List<CommentVo> getCommentListByParent(CommentSearchVo searchVo) {
        int totalRowCount = commentDao.getCommentCountByParent();
        searchVo.setTotalRowCount(totalRowCount);
        searchVo.pageSetting();
        List<CommentVo> commentList=CommentDao.getCommentListByParent(searchVo);

        return commentList;
    }

    @Override
    public void commentEdit(CommentVo comment) {
        CommentVo vo=CommentDao.getComment(comment.getReNo());
        if(!vo.getUsername().equals((comment.getUsername())));
        CommentDao.updateComment(comment);

    }

    @Override
    public void commentDelete(CommentVo comment) {
    CommentVo vo= CommentDao.getComment(comment.getComNo());
    if (!vo.getUsername().equals(comment.getUsername()));
    CommentDao.deleteComment(comment);
    }

    @Override
    public void commentWrite(CommentVo comment) {
        CommentDao.insertComment(comment);
    }
}
