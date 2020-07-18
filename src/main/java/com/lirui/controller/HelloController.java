package com.lirui.controller;

import com.lirui.listener.MyHttpSessionListener;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(true);
        session.setAttribute("aa","aa");
        return "hello";
    }

    @RequestMapping("online")
    public String online(){
        return "当前在线人数："+ MyHttpSessionListener.online +"人";
    }
}
