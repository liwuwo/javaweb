package com.service;


import com.domain.trace.TraceLog;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseJob {

    @Autowired
    private TraceLog traceLog;

    public void execute(){
        traceLog.traceBegin(this.getClass().getSimpleName());
        Object result = this.doWork();
        traceLog.traceEnd(this.getClass().getSimpleName(),result);
    }

    public abstract Object doWork();
}
