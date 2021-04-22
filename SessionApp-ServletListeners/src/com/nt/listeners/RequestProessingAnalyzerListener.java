package com.nt.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestProessingAnalyzerListener implements ServletRequestListener {
	private long startTime,endTime;
	
	public RequestProessingAnalyzerListener() {
		System.out.println("RequestProessingAnalyzerListener:: 0-param consturctor");
	}
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("RequestProessingAnalyzerListener.requestInitialized()");
	   startTime=System.currentTimeMillis();
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestProessingAnalyzerListener.requestDestroyed()");
		endTime=System.currentTimeMillis();
		//HttpServletRequest obj
		HttpServletRequest req=(HttpServletRequest)sre.getServletRequest();
	    System.out.println(req.getRequestURL()+" has taken "+(endTime-startTime)+" ms to process the request");
	    // get Servletcontext obj
	    ServletContext sc=req.getServletContext();
	    sc.log(req.getRequestURL()+" has taken "+(endTime-startTime)+" ms to process the request");
	}

}
