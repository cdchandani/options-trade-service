package com.chanchal.optionstradeservice.dao;

import com.chanchal.optionstradeservice.bo.OptionsTradesBO;
import com.chanchal.optionstradeservice.processor.impl.OptionsTradeProcessor;
import com.chanchal.optionstradeservice.repository.OptionsTradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TradeDao {
    private final Logger logger = LoggerFactory.getLogger(TradeDao.class);

    @Autowired
    private OptionsTradeProcessor transformer;
    @Autowired
    private OptionsTradeRepository repository;

    @CacheEvict(cacheNames = "optionsTrades", key = "#optionsTradesBO.id")
    public OptionsTradesBO persistData(OptionsTradesBO optionsTradesBO) {
        OptionsTradesBO savedOptionsTrade = repository.save(optionsTradesBO);
        logger.info("savedOptionsTrade::{}", savedOptionsTrade);
        return savedOptionsTrade;
    }

    @Cacheable(cacheNames = "optionsTrades", key = "id")
    public Optional<OptionsTradesBO> getData(Long id) {
        logger.info("fetching options trade from db");
        return repository.findById(id);
    }
}
