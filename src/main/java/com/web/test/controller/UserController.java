package com.web.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.test.domain.User;
import com.web.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YRS on 2017/10/9.
 */

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/show")
    public ModelAndView showAllUser(
            @RequestParam(required = true,defaultValue = "1") Integer pageNum,
            @RequestParam(required = true,defaultValue = "5") Integer pageSize,
            ModelAndView mv) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userService.findAllUser();
        PageInfo<User> pageUser = new PageInfo<User>(users);
        //mv.addObject("users",userService.findAllUser());
        mv.addObject("users",users);
        mv.addObject("pageUser",pageUser);
        mv.setViewName("showAllUser");
        return mv;
    }

    @RequestMapping("/user/add")
    @ResponseBody
    public int test(@RequestParam(value = "name", required = true)String name,
                    @RequestParam(value = "pwd", required = true)String pwd,
                    @RequestParam(value = "mail", required = true)String mail){
        Map<String, String> user = new HashMap<>();
        user.put("username",name);
        user.put("password",pwd);
        user.put("email",mail);
        int result = userService.addUser(user);
        return result;
    }

    @RequestMapping("/user/login")
    @ResponseBody
    public Boolean loginUser(@RequestBody User user, Model model, HttpSession session) {
        Boolean result = false;
        if (userService.checkLogin(user) != null) {
            model.addAttribute("user", user);
            session.setAttribute("user",user);
            model.addAttribute("user",user);
            result = true;
        }

        return result;
    }

    @RequestMapping("/user/regist")
    @ResponseBody
    public Boolean registUser(@RequestBody User user, Model model) {
        Boolean result = false;
        if (userService.checkRegist(user) == null) {
            Map<String, String> userMap = new HashMap<>();
            userMap.put("username",user.getUsername());
            userMap.put("password",user.getPassword());
            userMap.put("email",user.getEmail());
            userService.addUser(userMap);
            model.addAttribute("user", user);
            result = true;
        }
        return result;
    }
}
