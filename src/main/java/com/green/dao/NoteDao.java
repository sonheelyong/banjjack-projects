package com.green.dao;

import com.green.vo.NoteVo;

import java.util.List;

public interface NoteDao {
    void insertMsg(NoteVo vo);

    List<NoteVo> selectRecept(String recept);
}
