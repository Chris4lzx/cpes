package com.atguigu.crowdfunding.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

public class CrowdFundingStartupListener extends ContextLoaderListener{

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		ServletContext servletContext = event.getServletContext();
		String contextPath = servletContext.getContextPath();
		servletContext.setAttribute("APP_PATH", contextPath);
	}
}
