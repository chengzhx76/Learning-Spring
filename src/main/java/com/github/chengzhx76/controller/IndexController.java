package com.github.chengzhx76.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc:
 * @author: hp
 * @date: 2017/10/18
 */
@Controller
public class IndexController {
    @RequestMapping("index")
    public String index(HttpServletRequest request) {
        System.out.println("------------------");
        return "index";
    }
    @RequestMapping("test")
    public String test(HttpServletRequest request) {
        System.out.println("---------test---------");
        return "index";
    }
}