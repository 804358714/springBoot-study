package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;

@SpringBootTest
class SpringBootStudyApplicationTests {

    @Resource
    JavaMailSender sender;

    @Test
    void contextLoads() throws MessagingException, FileNotFoundException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
//        SimpleMailMessage message = new SimpleMailMessage();
        helper.setSubject("【上海理工大学教务处】关于近期学校对您的处分决定");
        helper.setText("李振山同学您好，经监控和教务巡查发现，您近期存在旷课、迟到、早退、上课刷抖音行为，" +
                "现已通知辅导员汪芯瑜，请手写5000字书面检讨，并在2023年5月20日12点前交到辅导员办公室。");
        helper.setFrom("jayceweb@163.com");
        helper.setTo("2645511622@qq.com");
        helper.addAttachment("通知.pdf",new File("D:\\JavaCode\\Java8\\spring-boot-study\\src\\main\\resources\\通知.pdf"));
        sender.send(message);
    }

}
