package com.mapper;

import com.entity.Book;
import org.apache.ibatis.annotations.Select;

public interface BookMapper {
    @Select("select * from books where book_name = #{bookName}")
    Book getBookByName(String bookName);
}
