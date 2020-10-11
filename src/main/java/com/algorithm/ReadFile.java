package com.algorithm;

import com.common.util.JsonUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;


//从一个日志文件中根据关键字读取日志，记录出现的次数，最后按照次数排序打印
public class ReadFile {

    private static void initKeysMap(Map<String,Integer> keysMap){
        keysMap.put("剑圣",0);
        keysMap.put("斧王",0);
        keysMap.put("骑士",0);
        keysMap.put("刺客",0);
        keysMap.put("精灵",0);
    }

    private static void applyString(String lineTxt,Map<String,Integer> keysMap){

        for(Map.Entry<String,Integer> entry :keysMap.entrySet()){
            String key = entry.getKey();
            int count = lineTxt.split(key).length-1;
            Integer val = entry.getValue();
            entry.setValue(val == null ? count:val + count);
        }
    }

    public static void main(String[] args) {

        new LinkedBlockingQueue();

        File file = new File("C:\\Users\\Administrator\\Desktop\\套路.txt");
        if(file.isFile() && file.exists()){
            try {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GBK");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt;
                Map<String,Integer> keysMap = new HashMap<>();
                initKeysMap(keysMap);
                while ((lineTxt = br.readLine()) != null) {
                    applyString(lineTxt+"#",keysMap);
                }
                System.out.println(JsonUtil.write2JsonStr(keysMap));
                br.close();

            }catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            System.out.println("文件不存在!");
        }
    }
}
