package com.web.test.service;

import com.web.test.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by YRS on 2017/10/9.
 */
public interface UserService {
    /**
     * 查询列表
     * **/
    List<User> findAllUser();
    int addUser(Map<String,String> user);
    User selectUserName(User user);
    User checkLogin(User user);
    void deleteUserById(Integer id);
    User checkRegist(User user);
}
