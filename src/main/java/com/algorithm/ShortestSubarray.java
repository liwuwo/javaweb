package com.algorithm;

public class ShortestSubarray {

    public static void main(String[] args) {
        int[] A = {2,-3,5,0,3,4};
        //System.out.println(shortestSubarray(A,9));
        String a = "aa";
        String b = new String("aa");
        System.out.println(a.equals(b));
    }

    public static int shortestSubarray(int[] A, int K) {
        if(A[0] >= K){
            return 1;
        }
        int originArrLen = A.length;
        int[] B = A.clone();
        int minLen = 1;
        while (minLen <= originArrLen) {
            for(int idx = originArrLen-1;idx >= minLen-1;idx--){
                if(A[idx] >= K){
                    return minLen;
                }
                if(idx > 0){
                    A[idx] = A[idx-1] + B[idx];
                }
            }
            minLen++;
        }
        return -1;
    }

}
