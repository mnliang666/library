package com.jxust.ssm.controller;

import com.jxust.ssm.pojo.User;
import com.jxust.ssm.service.UserService;
import com.jxust.ssm.utils.Encryption;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户登录，获取email和password
     * @return 用户和密码匹配成功，则返回true
     */
    @RequestMapping("/login")
    @ResponseBody
    public boolean login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = Encryption.encryptPassword(request.getParameter("password"));
        HttpSession session = request.getSession();
        User user = userService.userLogin(username, password);
        if (user != null) {
            session.setAttribute("user", user.getUsername());
            session.setAttribute("email",user.getEmail());
            return true;
        }
        return false;
    }

    /**
     * 用户注册
     * @return 注册成功，返回true
     */
    @RequestMapping("/register")
    @ResponseBody
    public boolean register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = Encryption.encryptPassword(request.getParameter("password"));
        String email = request.getParameter("email");
        request.getSession();
        return userService.userRegister(username, password, email);
    }

    /**
     * 用户退出功能
     */
    @RequestMapping("/logout")
    @ResponseBody
    public boolean logout(HttpServletRequest request) {
        //根据用户名获取这个用户的用户名，如果不为null就登出
        Object user = request.getSession().getAttribute("user");
        if (user != null) {
            request.getSession().removeAttribute("user");
            return true;
        }
        return false;
    }

    /**
     * 修改密码，成功返回true，否则返回false
     */
    @RequestMapping("/update")
    @ResponseBody
    public boolean updatePass(HttpServletRequest request) {
        Object email = request.getSession().getAttribute("email");
        String newPassword = Encryption.encryptPassword(request.getParameter("password"));
        if (userService.updatePassword(newPassword, email.toString())) {
            request.getSession().removeAttribute("user");
            return true;
        }
        return false;
    }


    @RequestMapping("/online")
    @ResponseBody
    public String online(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user");
        if (user != null) {
            return user.toString();
        } else {
            return null;
        }
    }

}
