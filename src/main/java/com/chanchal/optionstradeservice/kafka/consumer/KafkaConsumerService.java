package com.chanchal.optionstradeservice.kafka.consumer;

import com.chanchal.optionstradeservice.bo.ApplicationErrorBO;
import com.chanchal.optionstradeservice.bo.OptionsTradesBO;
import com.chanchal.optionstradeservice.dao.TradeDao;
import com.chanchal.optionstradeservice.processor.impl.OptionsTradeProcessor;
import com.chanchal.optionstradeservice.repository.ApplicationErrorRepository;
import com.chanchal.optionstradeservice.to.OptionsTradesTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class KafkaConsumerService {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @Autowired
    private TradeDao tradeDao;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ApplicationErrorRepository errorRepository;

    @Autowired
    private OptionsTradeProcessor transformer;

    @KafkaListener(topics = "option-trades-topic", groupId = "group-1")
    public void receiveMessageFromFirstExchange(String message, @Header(KafkaHeaders.OFFSET) Long offset, @Header(KafkaHeaders.RECEIVED_KEY) String key) {
        logger.info("received message with offset:{} and key: {}. Message:: {}", offset, key, message);
        try {
            OptionsTradesTO optionsTradesTO = objectMapper.readValue(message, OptionsTradesTO.class);
            OptionsTradesBO optionsTradesBO = transformer.processMessage(optionsTradesTO);
            OptionsTradesBO savedOptionsTradeBO = tradeDao.persistData(optionsTradesBO);
            logger.info("transformed and persisted options trade message for reporting");
        } catch (Exception e) {
            logger.error("Exception occurred while consuming message from options-trades-topic. Key:{}, message:{}", key, message);
            ApplicationErrorBO applicationErrorBO = ApplicationErrorBO.builder().messageType(key).source("First-Exchange").message(message).error(Arrays.toString(e.getStackTrace())).build();
            errorRepository.save(applicationErrorBO);
        }
    }
}
