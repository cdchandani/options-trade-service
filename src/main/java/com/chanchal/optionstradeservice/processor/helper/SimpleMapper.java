package com.chanchal.optionstradeservice.processor.helper;

import com.chanchal.optionstradeservice.bo.OptionsTradesBO;
import com.chanchal.optionstradeservice.to.OptionsTradesTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SimpleMapper {

    SimpleMapper INSTANCE = Mappers.getMapper(SimpleMapper.class);

    OptionsTradesBO optionsTradesTOToOptionsTradesBO(OptionsTradesTO source);
}