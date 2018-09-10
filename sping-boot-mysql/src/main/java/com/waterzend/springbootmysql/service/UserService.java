package com.waterzend.springbootmysql.service;

import com.waterzend.springbootmysql.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> listUser();
}
