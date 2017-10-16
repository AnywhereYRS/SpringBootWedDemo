package com.web.test.service.impl;

import com.web.test.dao.UserDao;
import com.web.test.domain.User;
import com.web.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by YRS on 2017/10/9.
 */

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAllUser() {
        return userDao.selectAll();
    }
    @Override
    public int addUser(Map<String,String> userMap) {
        User user = new User();
        user.setUsername(userMap.get("username"));
        user.setPassword(userMap.get("password"));
        user.setEmail(userMap.get("email"));
        return userDao.addUser(user);
    }
    @Override
    public User selectUserName(User user) {
        return userDao.selectByUsername(user);
    }
    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteById(id);
    }
    @Transactional(readOnly=true)
    @Override
    public User checkLogin(User user) {
        return userDao.selectByUsernameAndPassword(user);
    }

    @Override
    public User checkRegist(User user) {
        return userDao.selectByUsername(user);
    }
}
