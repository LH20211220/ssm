package com.lh.ssm.service.impl;

import com.lh.ssm.mapper.UserInfoMapper;
import com.lh.ssm.pojo.User;
import com.lh.ssm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void add(User userInfo) {

        userInfoMapper.add(userInfo);
    }

    @Override
    public void delete(Integer id) {
        userInfoMapper.delete(id);
    }

    @Override
    public void update(User userInfo) {
        userInfoMapper.update(userInfo);
    }

    @Override
    public User queryById(Integer id) {
        return userInfoMapper.queryById(id);
    }

    @Override
    public List<User> queryAll() {
        return userInfoMapper.queryAll();
    }
}

