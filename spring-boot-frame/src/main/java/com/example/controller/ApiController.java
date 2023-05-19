package com.example.controller;

import com.example.entity.RestBean;
import com.example.service.VerifyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/auth")
public class ApiController {
    @Resource
    VerifyService service;
    @GetMapping("/verify-code")
    public RestBean verifyCode(@RequestParam String mail){
        try {
            service.sendVerifyMail(mail);
            return new RestBean(200,"邮件发送成功");
        }catch (Exception e){
            return new RestBean(500,"邮件发送失败");
        }
    }

    @PostMapping("/register")
    public RestBean register(String username,
                             String password,
                             String mail,
                             String verify){
        System.out.println("正在访问");
        if (service.doVerify(mail,verify)){
            return new RestBean(200,"注册成功");
        }else {
            return new RestBean(403,"注册失败");
        }
    }
}
