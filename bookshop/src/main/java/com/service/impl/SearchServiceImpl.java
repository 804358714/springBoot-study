package com.service.impl;

import com.entity.Book;
import com.mapper.BookMapper;
import com.service.SearchService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class SearchServiceImpl implements SearchService {
    @Resource
    BookMapper mapper;
    @Resource
    RedisTemplate<Object,Book> redisTemplate;
    @Override
    public Book getBookByName(String bookName) {
        Book book = redisTemplate.opsForValue().get(bookName);
        if (book==null){
            Book newBook = mapper.getBookByName(bookName);
            if (newBook != null){
                redisTemplate.opsForValue().set(newBook.getBookName(),newBook);
            }
            return newBook;
        }else {
            return book;
        }
    }
}
