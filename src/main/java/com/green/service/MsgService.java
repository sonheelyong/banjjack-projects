package com.green.service;


import com.green.dao.MsgDao;
import com.green.dao.impl.MsgDaoImpl;
import com.green.vo.MsgVo;
import com.green.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgService {

    @Autowired
    MsgDaoImpl msgDaoImpl;

    


    public void insertMsg(MsgVo vo) {
        msgDaoImpl.insertMsg(vo);
    }

    public List<MsgVo> selectRecept(String recept){
        List<MsgVo> vo = msgDaoImpl.selectRecept(recept);
        return vo;
    }
}
