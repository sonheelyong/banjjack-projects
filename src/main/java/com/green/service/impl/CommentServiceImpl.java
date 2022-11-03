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
    public CommentDao commentDao ;
    @Override
    public List<CommentVo> list(Integer _id) {
        return commentDao.list(_id);
    }

    @Override
    public void write(CommentVo vo) {
        commentDao.write(vo);

    }

    @Override
    public void update(CommentVo vo) {

    }

    @Override
    public void delete(Integer _id) {

    }
}
