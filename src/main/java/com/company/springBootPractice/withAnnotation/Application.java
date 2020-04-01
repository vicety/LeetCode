package com.company.springBootPractice.withAnnotation;

import com.company.springBootPractice.withAnnotation.utils.ContextUtils;
import com.company.springBootPractice.withAnnotation.utils.HashMapExample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        if(ContextUtils.applicationContext == null) {
            System.out.println("null");
            return;
        }
        Map<Integer, Integer> mp = (Map) ContextUtils.applicationContext.getBean(HashMap.class);
        System.out.println(mp.get(1));
    }
}
