package com.bookstore.mapper;

import com.bookstore.dbentity.Book;
import com.bookstore.dbentity.BookExample;
import com.bookstore.dbentity.BookWithBLOBs;
import java.util.List;

import com.bookstore.dbentity.SimpleBookExample;
import com.bookstore.web.entity.FEBook;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper {
    int countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int insert(BookWithBLOBs record);

    int insertSelective(BookWithBLOBs record);

    List<BookWithBLOBs> selectByExampleWithBLOBs(BookExample example);

    List<Book> selectByExample(BookExample example);

    int updateByExampleSelective(@Param("record") BookWithBLOBs record, @Param("example") BookExample example);

    int updateByExampleWithBLOBs(@Param("record") BookWithBLOBs record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    List<FEBook> selectTopSaleBook(SimpleBookExample simpleBookExample);

    List<FEBook> selectBooksByCategory(String category);

    FEBook selectBookInfo(String isbn);
}