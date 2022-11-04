package com.green.controller;

import com.green.service.UserService;
import com.green.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

@Controller
public class LoginController{

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }


    @RequestMapping("/sign-up")
    public String signup() {
        return "/sign-up";
    }

    // 아이디 중복확인
    @PostMapping("/sign-up/usernameCheck")
    @ResponseBody
    public int usernameCheck(@RequestParam("username") String username) {
        System.out.println(username);
        int count = 0;
        count = userService.usernameCheck(username);
        System.out.println(count);
        return count;

    }

    // 닉네임 중복확인
    @PostMapping("/sign-up/nicknameCheck")
    @ResponseBody
    public int nicknameCheck(@RequestParam("usernickname") String usernickname) {
        return userService.nicknameCheck(usernickname);
    }


    // 회원가입 (정보등록)
    @PostMapping("/sign-up/register")
    @ResponseBody
    public String insertInfo(@RequestParam("username") String username, @RequestParam("userpassword") String userpassword,
                             @RequestParam("usernickname") String usernickname) {
        UserVo userVo = new UserVo(0, username, userpassword, usernickname);
        userService.insertInfo(userVo);
        System.out.println(userVo);
        return "redirect:/";
    }

    // 로그인-아이디 매치 Session 배치


    // 로그인-비밀번호 매치 Session



}