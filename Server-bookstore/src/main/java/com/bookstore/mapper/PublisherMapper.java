package com.bookstore.mapper;

import com.bookstore.dbentity.Publisher;
import com.bookstore.dbentity.PublisherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherMapper {
    int countByExample(PublisherExample example);

    int deleteByExample(PublisherExample example);

    int insert(Publisher record);

    int insertSelective(Publisher record);

    List<Publisher> selectByExampleWithBLOBs(PublisherExample example);

    List<Publisher> selectByExample(PublisherExample example);

    int updateByExampleSelective(@Param("record") Publisher record, @Param("example") PublisherExample example);

    int updateByExampleWithBLOBs(@Param("record") Publisher record, @Param("example") PublisherExample example);

    int updateByExample(@Param("record") Publisher record, @Param("example") PublisherExample example);
}