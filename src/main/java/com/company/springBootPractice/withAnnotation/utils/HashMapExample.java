package com.company.springBootPractice.withAnnotation.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class HashMapExample {
    @Bean
    public Map<Integer, Integer> defaultHashMap() {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(1, 2);
        return mp;
    }
}
