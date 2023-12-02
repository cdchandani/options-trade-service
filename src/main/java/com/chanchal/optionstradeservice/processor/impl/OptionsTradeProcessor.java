package com.chanchal.optionstradeservice.processor.impl;

import com.chanchal.optionstradeservice.bo.ClientBO;
import com.chanchal.optionstradeservice.bo.OptionsTradesBO;
import com.chanchal.optionstradeservice.processor.IMessageProcessor;
import com.chanchal.optionstradeservice.processor.helper.SimpleMapper;
import com.chanchal.optionstradeservice.to.OptionsTradesTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class OptionsTradeProcessor implements IMessageProcessor<OptionsTradesBO, OptionsTradesTO> {
    private final Logger logger = LoggerFactory.getLogger(OptionsTradeProcessor.class);

    @Autowired
    private RestTemplate restTemplate;
    @Value("${staticdata.service.url}")
    private String staticServiceUrl;

    @Override
    public OptionsTradesBO processMessage(OptionsTradesTO optionsTradesTO) {
        SimpleMapper instance = SimpleMapper.INSTANCE;
        OptionsTradesBO futuresTradesBO = instance.optionsTradesTOToOptionsTradesBO(optionsTradesTO);
        URI uri = UriComponentsBuilder.fromUriString(staticServiceUrl).path("/client")
                .queryParam("code", "mac").build().encode().toUri();
        long start = System.currentTimeMillis();
        ClientBO client = restTemplate.getForObject(uri, ClientBO.class);
        long end = System.currentTimeMillis();
        logger.info("static data received in {} ms", end - start);
        if (client != null) {
            futuresTradesBO.setBrokerClient(client.getName());
        }
        return futuresTradesBO;
    }
}





