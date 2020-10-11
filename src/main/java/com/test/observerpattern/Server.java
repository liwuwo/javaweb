package com.test.observerpattern;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Server implements ObServerable{

    private List<ObServer> obList;

    public Server(){
        obList = new ArrayList<>();
    }

    @Override
    public void createOb(ObServer ob) {
        sendMsg("***" + ob.getName() + "*** 加入了观察组！");
        obList.add(ob);
    }

    @Override
    public void deleteOb(ObServer ob) {
        obList.remove(ob);
        sendMsg("***" + ob.getName() + "*** 离开了观察组！");
    }

    @Override
    public void sendMsg(String msg) {
        if(!CollectionUtils.isEmpty(obList)){
            obList.forEach(ob-> ob.refresh(msg));
        }
        System.out.println("------------------");
    }

    public void setMsg(String msg){
        sendMsg(msg);
    }
}
