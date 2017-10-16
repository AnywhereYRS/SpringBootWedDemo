package com.web.test.dao;

import com.web.test.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by YRS on 2017/10/9.
 */
public interface UserDao {
    List<User> selectAll();
    int addUser(User user);
    User selectByUsername(User user);
    void deleteById(Integer id);
    User selectByUsernameAndPassword(User user);
}
