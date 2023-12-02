package com.chanchal.optionstradeservice.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IMapper<K> {
    K map(String message) throws JsonProcessingException;
}
