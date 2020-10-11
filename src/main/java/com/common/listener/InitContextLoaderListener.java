package com.common.listener;

import com.domain.trace.TraceLog;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;

public class InitContextLoaderListener extends ContextLoaderListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        TraceLog traceLog = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext()).getBean(TraceLog.class);
        traceLog.traceBegin("*** !!contextInitialized start ***");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }
}
