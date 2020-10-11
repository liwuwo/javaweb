package com.controller;

import com.common.util.JsonUtil;
import com.domain.UserEvent;
import com.domain.result.ResultData;
import com.service.index.IndexService;
import com.service.index.InitAutoJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private InitAutoJob initAutoJob;

    @Autowired
    private IndexService indexService;

    @RequestMapping("/index")
    @ResponseBody
    public ResultData index() {

        System.out.println("IndexController.index");
        initAutoJob.execute();
        indexService.process();
        return new ResultData("2","成功");
    }

    public static void main(String[] args) {
        UserEvent us1 = new UserEvent();
        us1.setUserId("1112321");
        us1.setUserName("sfsfs");
        UserEvent us2 = new UserEvent();
        us2.setUserId("45245346");
        us2.setUserName("hythj5");

        List<UserEvent> list = new ArrayList<>();
        list.add(us1);
        list.add(us2);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        MultiValueMap<String,Object> body = new LinkedMultiValueMap<>();
        body.add("userEvent",JsonUtil.write2JsonStr(list));
        HttpStatus status = restTemplate.exchange("http://localhost:8080/test",
                HttpMethod.POST,new HttpEntity<>(body,headers),Object.class).getStatusCode();
        System.out.println(status.toString());
    }

}