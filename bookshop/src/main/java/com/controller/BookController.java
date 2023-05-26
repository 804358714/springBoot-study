package com.controller;

import com.service.SearchService;
import com.service.impl.SearchServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class BookController {
    @Resource
    SearchService service;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String search(Model model,String bookName){
        model.addAttribute("book",service.getBookByName(bookName));
        return "book";
    }
}
