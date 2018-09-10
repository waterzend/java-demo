package com.waterzend.springbootmysql.mapper;

import com.waterzend.springbootmysql.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {

    User selectUserById(Integer id);

    List<User> selectAll();

    void insert(User personDO);

    Long update(User personDO);

    Long delete(Long id);
}
