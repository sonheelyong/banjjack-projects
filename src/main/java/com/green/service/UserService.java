package com.green.service;

import com.green.dao.impl.UserDaoImpl;
import com.green.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDaoImpl userDaoImpl;

    public List<UserVo> selectAll(){
        return userDaoImpl.selectAll();
    }

    public int insertUser(UserVo userVo){
        return userDaoImpl.insertUser(userVo);
    }
}
