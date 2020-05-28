package com.cwy.dao.mapper.impl;

import com.cwy.dao.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface UserMapperImpl {

    User selectUserByParam(User user);

    /**
     *  通过手机号查找用户
     * @param phone 手机号
     * @return 用户
     */
    com.cwy.dao.model.User findByPhone(String phone);

}
