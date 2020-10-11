package com.domain.result;

import com.common.enums.ResultEnum;

import java.io.Serializable;

public class ResultData implements Serializable{

    private static final long serialVersionUID = -6580927288363475156L;

    private String code;

    private String msg;

    private Object result;

    public ResultData(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.result = null;
    }

    public ResultData(ResultEnum res,Object result){
        this.code = res.getCode();
        this.msg = res.getMsg();
        this.result = result;
    }

    public ResultData(String code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
