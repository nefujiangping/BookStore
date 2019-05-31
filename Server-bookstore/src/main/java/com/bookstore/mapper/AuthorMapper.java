package com.bookstore.mapper;

import com.bookstore.dbentity.Author;
import com.bookstore.dbentity.AuthorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorMapper {
    int countByExample(AuthorExample example);

    int deleteByExample(AuthorExample example);

    int insert(Author record);

    int insertSelective(Author record);

    List<Author> selectByExampleWithBLOBs(AuthorExample example);

    List<Author> selectByExample(AuthorExample example);

    int updateByExampleSelective(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByExampleWithBLOBs(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByExample(@Param("record") Author record, @Param("example") AuthorExample example);
}