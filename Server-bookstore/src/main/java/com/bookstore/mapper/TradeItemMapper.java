package com.bookstore.mapper;

import com.bookstore.dbentity.TradeItem;
import com.bookstore.dbentity.TradeItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeItemMapper {
    int countByExample(TradeItemExample example);

    int deleteByExample(TradeItemExample example);

    int insert(TradeItem record);

    int insertSelective(TradeItem record);

    List<TradeItem> selectByExample(TradeItemExample example);

    int updateByExampleSelective(@Param("record") TradeItem record, @Param("example") TradeItemExample example);

    int updateByExample(@Param("record") TradeItem record, @Param("example") TradeItemExample example);
}