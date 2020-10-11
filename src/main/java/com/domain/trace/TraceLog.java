package com.domain.trace;

import com.common.util.JsonUtil;

public class TraceLog {

    private String methodName;

    private Object result;

    public TraceLog(){

    }

    public TraceLog(String methodName, Object result) {
        this.methodName = methodName;
        this.result = result;
    }

    public void traceBegin(String methodName){
        System.out.println("trace start! methodName = *** " + methodName + " ***");
    }

    public void traceEnd(String methodName, Object result){
        System.out.println("trace end! methodName = *** " + methodName + " ***, result = " + JsonUtil.write2JsonStr(result));
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
