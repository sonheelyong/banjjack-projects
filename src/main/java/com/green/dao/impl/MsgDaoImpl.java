package com.green.dao.impl;

import com.green.dao.MsgDao;
import com.green.vo.MsgVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("msgDao")
public class MsgDaoImpl implements MsgDao {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public void insertMsg(MsgVo vo) {
        sqlSession.insert("Msg.MsgWrite",vo);
    }

    @Override
    public List<MsgVo> selectRecept(String recept) {
        List<MsgVo> vo = sqlSession.selectList("Msg.selectRecept",recept);
        return vo;
    }
}
