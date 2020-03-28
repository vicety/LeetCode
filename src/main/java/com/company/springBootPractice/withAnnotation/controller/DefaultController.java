package com.company.springBootPractice.withAnnotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class DefaultController {
    @Autowired
    Map<Integer, Integer> mp;

    @RequestMapping("/")
    public String defaultMapping(@RequestParam("id") Integer id) {
        System.out.print("here");
        return String.valueOf(mp.get(id));
    }
}
