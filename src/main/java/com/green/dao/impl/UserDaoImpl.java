package com.green.dao.impl;

import com.green.dao.UserDao;
import com.green.vo.UserVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<UserVo> selectAll() {
        return sqlSession.selectList("User.selectAll");
    }

    @Override
    public int insertUser(UserVo userVo) {
        return sqlSession.insert("User.insertUser", userVo);
    }
}
