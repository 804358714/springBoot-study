package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class MainController {
    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        MDC.put("reqId", request.getSession().getId());
        log.info("用户访问了一次登陆界面");
        return "index";
    }
}
