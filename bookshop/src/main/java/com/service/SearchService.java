package com.service;

import com.entity.Book;
import com.mapper.BookMapper;

import javax.annotation.Resource;

public interface SearchService {
    Book getBookByName(String bookName);
}
