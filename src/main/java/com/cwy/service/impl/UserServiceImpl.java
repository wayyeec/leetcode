package com.cwy.service.impl;

import com.cwy.constant.RoleConstant;
import com.cwy.dao.mapper.impl.UserMapperImpl;
import com.cwy.dao.po.User;
import com.cwy.service.UserService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wayyee
 * @Date: 2020/03/01 15:56
 * Describe: user表接口具体业务逻辑
 */
@Service
public class UserServiceImpl implements UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static String infoHeader = "user表接口具体业务逻辑";

    @Autowired
    UserMapperImpl userMapper;

    @Override
    public User findUserByPhone(String phone) {
        User user = new User();
        user.setPhone(phone);
        return userMapper.findUserByParam(user);
    }

    @Override
    public String findUsernameById(int id) {
        User user = new User();
        user.setId(id);
        return userMapper.findUserByParam(user).getUsername();
    }

    @Override
    public String insert(User user) {
        if(userIsExit(user.getPhone())){
            return "1";
        }
        if("male".equals(user.getGender())){
            user.setAvatarimgurl("male.jpg");
        } else {
            user.setAvatarimgurl("female.jpg");
        }
        userMapper.insert(user);

        int userId = userMapper.findUserByParam(user).getId();
        insertRole(userId, RoleConstant.ROLE_USER);
        return "2";
    }



    @Override
    public void updatePasswordByPhone(String phone, String password) {
        userMapper.updatePassword(phone, password);
    }

    @Override
    public String findPhoneByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        return userMapper.findUserByParam(user).getPhone();
    }

    @Override
    public int findIdByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        return userMapper.findUserByParam(user).getId();
    }

    @Override
    public boolean usernameIsExit(String username) {
        User user = new User();
        user.setUsername(username);
        return userMapper.findUserByParam(user) != null;
    }

    @Override
    public boolean isSuperAdmin(String phone) {
        User user = new User();
        user.setPhone(phone);
        int userId = userMapper.findUserByParam(user).getId();
        List<Object> roleIds = userMapper.findRoleIdByUserId(userId);

        for(Object i : roleIds){
            if((int)i == 3){
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateAvatarImgUrlById(String avatarImgUrl, int id) {
        userMapper.updateAvatarImgUrlById(avatarImgUrl, id);
    }

    @Override
    public JSONObject getHeadPortraitUrl(int id) {
        JSONObject jsonObject = new JSONObject();
        String avatarImgUrl = userMapper.getHeadPortraitUrl(id);
        if(!"".equals(avatarImgUrl) && avatarImgUrl != null){
            jsonObject.put("status",200);
            jsonObject.put("avatarImgUrl",avatarImgUrl);
        }
        return jsonObject;
    }

    @Override
    public JSONObject getUserPersonalInfoByUsername(String username) {
        User user = userMapper.getUserPersonalInfoByUsername(username);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",200);
        JSONObject userJon = new JSONObject();
        userJon.put("phone",user.getPhone());
        userJon.put("username",user.getUsername());
        userJon.put("gender",user.getGender());
        userJon.put("trueName",user.getTruename());
        userJon.put("birthday",user.getBirthday());
        userJon.put("email",user.getEmail());
        userJon.put("personalBrief",user.getPersonalbrief());
        userJon.put("avatarImgUrl",user.getAvatarimgurl());
        jsonObject.put("result",userJon);
        return jsonObject;
    }

    @Override
    public JSONObject savePersonalDate(User user, String username) {
        JSONObject returnJson = new JSONObject();

        //改了昵称
        if(!user.getUsername().equals(username)){
            if(usernameIsExit(user.getUsername())){
                returnJson.put("status",500);
                return returnJson;
            }
            returnJson.put("status",200);
            //注销当前登录用户
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        //没改昵称
        else {
            returnJson.put("status",201);
        }
        userMapper.savePersonalDate(user, username);

        return returnJson;
    }

    @Override
    public String getHeadPortraitUrlByUserId(int userId) {
        return userMapper.getHeadPortraitUrl(userId);
    }

    @Override
    public int countUserNum() {
        return userMapper.countUserNum();
    }


    /**
     * 增加用户权限
     * @param userId 用户id
     * @param roleId 权限id
     */
    private void insertRole(int userId, int roleId) {
        userMapper.insertRole(userId, roleId);
    }

    /**
     * 通过手机号判断用户是否存在
     * @param phone 手机号
     * @return true--存在  false--不存在
     */
    private boolean userIsExit(String phone){
        User user = this.findUserByPhone(phone);
        return user != null;
    }
}
