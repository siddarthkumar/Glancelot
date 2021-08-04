package com.glancelot.service;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionListenerWithMetrics implements HttpSessionListener {

	@Autowired
	HttpSession session;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSessionListener.super.sessionCreated(se);
		System.out.println("Session is created");
	
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSessionListener.super.sessionDestroyed(se);
		System.out.println("Session is destroyed");
	}

    
}