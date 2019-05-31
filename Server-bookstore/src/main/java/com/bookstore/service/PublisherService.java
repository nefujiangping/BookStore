package com.bookstore.service;

import com.bookstore.dbentity.Publisher;
import com.bookstore.dbentity.PublisherExample;
import com.bookstore.mapper.PublisherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PublisherService {

    @Autowired
    PublisherMapper publisherMapper;

    public Publisher getPublisherInfo(int publisherId){
        PublisherExample example = new PublisherExample();
        example.createCriteria().andPublisherIdEqualTo(publisherId);
        return publisherMapper.selectByExampleWithBLOBs(example).get(0);
    }
}
