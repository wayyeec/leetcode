package com.cwy.dao.model;

import com.cwy.dao.po.User;
import lombok.Data;

import java.util.List;

/**
 * @author: wayyee
 * @Date: 2020/6/4 11:49
 * Describe: 用户实体类
 */
@Data
public class UserDao extends User {


    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


}
