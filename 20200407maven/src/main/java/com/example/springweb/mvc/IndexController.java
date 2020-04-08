package com.example.springweb.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/home")   //����·��ӳ��Ϊ/home,����http://localhost:8080/springmvc-maven/���ܷ��ʵ�
    public String home() {    //�� �﷽����Sring���ͣ����Ҫ��WEB-INF����һ��home.jsp��ҳ��
        return "home";
    }

}