package com.controller;

import com.domain.result.ResultData;
import com.service.amq.AmqSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ActiveMqController {

    @Autowired
    private AmqSenderService amqSenderService;

    @RequestMapping("/sendMsg")
    @ResponseBody
    public ResultData sendMsg(@RequestParam(required = false) String msg){
        amqSenderService.sendMsg(msg);
        System.out.println(msg);
        return new ResultData("","");
    }
}
