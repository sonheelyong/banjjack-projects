package com.green.service;

import com.green.vo.CommentVo;

import java.util.List;

public interface CommentService {

    public List<CommentVo> list (Integer _id) ;

    public void write(CommentVo vo);

    public void update(CommentVo vo);

    public void delete(Integer content_id);

}
