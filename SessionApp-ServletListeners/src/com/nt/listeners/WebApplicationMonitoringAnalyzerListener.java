package com.nt.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;

@WebListener
public class WebApplicationMonitoringAnalyzerListener implements ServletContextListener {
	private long startTime,endTime;
	private ServletContext sc;
	
	public WebApplicationMonitoringAnalyzerListener() {
		System.out.println("WebApplicationMonitoringAnalyzerListener:: 0-param consturctor");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("WebApplicationMonitoringAnalyzerListener.contextInitialized()");
	    startTime=System.currentTimeMillis();
	    //get access to ServletCotnext
	    sc=sce.getServletContext();
	    //write log messages
	    System.out.println("web application is deployed/restarted/reloaded at::"+new Date());
	    sc.log("web application is deployed/restarted/reloaded at::"+new Date());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("WebApplicationMonitoringAnalyzerListener.contextDestroyed()");
	  endTime=System.currentTimeMillis();
	  
	    System.out.println("web application is stopped/undeployed/reloaded::"+new Date());
	    System.out.println("webpplication running duration::"+(endTime-startTime)+" ms");
	    sc.log("web application is stopped/undeployed/reloaded::"+new Date());
	   sc.log("webpplication running duration::"+(endTime-startTime)+" ms");
	}
	

}
