package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomController {

    @RequestMapping("/invoke")
    @ResponseBody
    public String invoke(){
        return "CustomController.invoke success!";
    }
}
