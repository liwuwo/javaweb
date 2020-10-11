package com.algorithm;

import org.apache.commons.lang3.StringUtils;

//KMP算法
public class KMP {

    public static void main(String[] args) {
        getPos("acabaabaabcacaabc","abaabcac");
    }

    public static int getPos(String str,String temp){
        if(StringUtils.isNotBlank(str) && StringUtils.isNotBlank(temp)){
            //分割字符串成单个字符
            String[] strArr = str.split("");
            String[] tempArr = temp.split("");

            //获取字符串长度
            int strSize = strArr.length;
            int tempSize = tempArr.length;

            for(int i = 0;i < strSize-tempSize+1; i++){
                for(int j = 0;j < tempSize;j++){
                    if(strArr[i].equals(tempArr[j])){
                        if(j == tempSize-1){
                            return j-tempSize+1;
                        }
                        i++;
                        j++;
                    }else{
                        j = getNextPos(j);
                    }
                }
            }
        }
        return -1;
    }

    public static int[] position(String[] tempArr){

        int tempSize = tempArr.length;
        int[] resultPos = new int[tempSize];
        resultPos[0] = -1;
        for(int i = 1;i < tempSize;i++){
            int k = 0;
            for(int j = 1;j < i;j++){
                if(tempArr[j].equals(tempArr[k])){
                    k++;
                }
            }

        }

        return resultPos;
    }

    public static int getNextPos(int currentPos){

        return 0;
    }
}
