package com.springboot.demo.repository;

import com.springboot.demo.model.pojo.t_user;

public interface t_userMapper {
    int insert(t_user record);

    int insertSelective(t_user record);
}