package com.company.springBootPractice.withAnnotation;

import com.company.springBootPractice.withAnnotation.entity.Human;
import com.company.springBootPractice.withAnnotation.utils.ContextUtils;
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
//        Map<Integer, Integer> mp = (Map) ContextUtils.applicationContext.getBean(HashMap.class);
//        System.out.println(mp.get(1));
//        Human human = ContextUtils.applicationContext.getBean(Human.class);
        Human human = (Human) ContextUtils.applicationContext.getBean("HumanFactory");
        if(human == null) System.out.println("null");
        else System.out.println(human.getName());
    }
}
