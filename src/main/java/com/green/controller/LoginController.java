package com.green.controller;

import com.green.service.UserService;
import com.green.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/sign-up/usernameCheck")
    @ResponseBody
    public int idCheck(@RequestParam("username") String username) {

        int count = 0;

        if(username != null) {
            count = userService.getUserName(username);
        }

        return count;

    }

    // 닉네임 중복확인
    @GetMapping("/sign-up/nicknameCheck")
    @ResponseBody
    public int nicknameCheck(@RequestParam("usernickname") String usernickname) {
        int count = 0;

        if(usernickname != null) {
            count = userService.getNickName(usernickname);
        }

        return count;
    }


    // 회원가입 (정보등록)
    @PostMapping("/sign-up/register")
    @ResponseBody
    public String insertInfo(@RequestParam("username") String username, @RequestParam("userpassword") String userpassword, @RequestParam("repasswd") String repasswd,
                           @RequestParam("usernickname") String usernickname) {
        UserVo userVo = new UserVo(0, username, userpassword, usernickname);
        userService.insertInfo(userVo);
        System.out.println(userVo);
        return "redirect:/";  // 회원가입 성공/실패시?
    }

    // 로그인-아이디 매치 Session 배치


    // 로그인-비밀번호 매치 Session



}