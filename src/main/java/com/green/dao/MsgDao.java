package com.green.dao;

import com.green.vo.MsgVo;

import java.util.List;

public interface MsgDao {
    void insertMsg(MsgVo vo);

    List<MsgVo> selectRecept(String recept);
}
