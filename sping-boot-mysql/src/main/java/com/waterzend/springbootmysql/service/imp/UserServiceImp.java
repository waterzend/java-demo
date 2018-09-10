package com.waterzend.springbootmysql.service.imp;

import com.waterzend.springbootmysql.domain.User;
import com.waterzend.springbootmysql.mapper.UserMapper;
import com.waterzend.springbootmysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> listUser() {
        return userMapper.selectAll();
    }
}
