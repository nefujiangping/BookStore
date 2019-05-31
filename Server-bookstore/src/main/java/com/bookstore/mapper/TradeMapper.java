package com.bookstore.mapper;

import com.bookstore.dbentity.Trade;
import com.bookstore.dbentity.TradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeMapper {
    int countByExample(TradeExample example);

    int deleteByExample(TradeExample example);

    int insert(Trade record);

    int insertSelective(Trade record);

    List<Trade> selectByExample(TradeExample example);

    int updateByExampleSelective(@Param("record") Trade record, @Param("example") TradeExample example);

    int updateByExample(@Param("record") Trade record, @Param("example") TradeExample example);
}