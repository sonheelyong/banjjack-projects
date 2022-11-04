package com.green.dao.impl;

import com.green.dao.NoteDao;
import com.green.vo.NoteVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("msgDao")
public class NoteDaoImpl implements NoteDao {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public void insertNote(NoteVo vo) {
        sqlSession.insert("Note.insertNote",vo);
    }

    @Override
    public List<NoteVo> selectRecept(String recept) {
        List<NoteVo> vo = sqlSession.selectList("Note.selectRecept",recept);
        return vo;
    }
}
