package com.green.service;


import com.green.dao.impl.NoteDaoImpl;
import com.green.vo.NoteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    NoteDaoImpl msgDaoImpl;

    


    public void insertMsg(NoteVo vo) {
        msgDaoImpl.insertMsg(vo);
    }

    public List<NoteVo> selectRecept(String recept){
        List<NoteVo> vo = msgDaoImpl.selectRecept(recept);
        return vo;
    }
}
