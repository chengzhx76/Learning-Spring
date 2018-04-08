package com.github.chengzhx76.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Desc:
 * @author: hp
 * @date: 2017/10/18
 */
@Controller
public class IndexController {
    @RequestMapping("index")
    public String index(HttpServletRequest request, HttpSession session) {
        System.out.println("------------------");
        return "index";
    }
    @RequestMapping("test")
    public String test(HttpServletRequest request) {
        System.out.println("---------test---------");
        return "index";
    }
}
