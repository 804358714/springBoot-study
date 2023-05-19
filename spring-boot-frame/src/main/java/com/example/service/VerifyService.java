package com.example.service;

public interface VerifyService {
    void sendVerifyMail(String mail);
    boolean doVerify(String mail,String code);
}
