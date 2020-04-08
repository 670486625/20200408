package com.example.springweb.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/home")   //这里路由映射为/home,所以http://localhost:8080/springmvc-maven/不能访问到
    public String home() {    //这 里方法是Sring类型，因此要在WEB-INF创建一个home.jsp的页面
        return "home";
    }

}