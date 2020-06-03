package com.cwy.dao.mapper.impl;

import com.cwy.dao.mapper.UserMapper;
import com.cwy.dao.model.UserDao;
import com.cwy.dao.po.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface UserMapperImpl extends UserMapper {

    User findUserByParam(User user);

    @Insert("insert into user_role(User_id, Role_id) values (#{userId}, #{roleId})")
    void insertRole(@Param("userId") int userId, @Param("roleId") int roleId);

    @Select("select Role_id from user_role where User_id=#{userId}")
    List<Object> findRoleIdByUserId(@Param("userId") int userId);

    @Update("update user set password=#{password} where phone=#{phone}")
    void updatePassword(@Param("phone") String phone, @Param("password") String password);

    @Update("update user set avatarImgUrl=#{avatarImgUrl} where id=#{id}")
    void updateAvatarImgUrlById(@Param("avatarImgUrl") String avatarImgUrl, @Param("id") int id);

    @Select("select avatarImgUrl from user where id=#{id}")
    String getHeadPortraitUrl(@Param("id") int id);

    @Select("select * from user where username=#{username}")
    User getUserPersonalInfoByUsername(@Param("username") String username);

    @Update("update user set username=#{user.username},gender=#{user.gender},trueName=#{user.trueName},birthday=#{user.birthday},email=#{user.email},personalBrief=#{user.personalBrief} where username=#{username}")
    void savePersonalDate(@Param("user") User user, @Param("username") String username);

    @Select("select count(*) from user")
    int countUserNum();

}
