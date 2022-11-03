package com.green.dao;

import com.green.vo.CommentVo;

import java.util.List;

public interface CommentDao {
    public  List<CommentVo> list(Integer _id);

    void write(CommentVo vo);

    void update(CommentVo vo);

    void delete(Integer content_id );

}
