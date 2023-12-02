package com.chanchal.optionstradeservice.processor;

public interface IMessageProcessor<K, V> {
    K processMessage(V request);
}
