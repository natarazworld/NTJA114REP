package com.nt.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionDurationAnalyzerListener implements HttpSessionListener {
	private long startTime,endTime;
	private ServletContext sc;
	
	public SessionDurationAnalyzerListener() {
		System.out.println("SessionDurationAnalyzerListener:: 0-param consturctor");
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("SessionDurationAnalyzerListener.sessionCreated()");
	    startTime=System.currentTimeMillis();
	    //get access to session
	    sc=se.getSession().getServletContext();
	    //write log messages
	    System.out.println("Session stated at::"+new Date());
	    sc.log("Session stated at::"+new Date());
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SessionDurationAnalyzerListener.sessionDestroyed()");
	  endTime=System.currentTimeMillis();
	    System.out.println("Sesson Ended at::"+new Date());
	    System.out.println("Sesson duration::"+(endTime-startTime)+" ms");
	    sc.log("Session ended at::"+new Date());
	   sc.log("Sesson duration::"+(endTime-startTime)+" ms");
	}
	

}
