package com.green.controller;

import com.green.service.UserService;
import com.green.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController{

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public String login() {
        return "/login";
    }


    @RequestMapping("/signup")
    public String signup() {
        return "/signup";
    }

    // 아이디 중복확인
    @RequestMapping(value="/signup/usernameCheck", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public int usernameCheck(@RequestParam String username) {
        System.out.println(username);
        return userService.usernameCheck(username);

    }

    // 닉네임 중복확인
    @GetMapping("/signup/nicknameCheck")
    @ResponseBody
    public int nicknameCheck(@RequestParam("usernickname") String usernickname) {
        return userService.nicknameCheck(usernickname);
    }


    // 회원가입 (정보등록)
    @PostMapping("/signup/register")
    public String insertInfo(@RequestParam("username") String username, @RequestParam("userpassword") String userpassword,
                             @RequestParam("usernickname") String usernickname) {
        UserVo userVo = new UserVo(0, username, userpassword, usernickname);
        System.out.println(userVo.toString());

        userService.insertInfo(userVo);

        return "/signup";
    }

    // 로그인-아이디 매치 Session 배치
    @RequestMapping(value="/login/successLogin", method = {RequestMethod.POST})
    public String successLogin(UserVo userVo) {
        System.out.println(userVo.toString());
        return "";
    }

    // user 정보 가져오기
    @GetMapping("/getUser")
    @ResponseBody
    public int getuser(@RequestParam("username") String username) {
        int i = userService.usernameCheck(username);
        return i;
    }



}