package com.andrius.project.AsynchronousExample2.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.andrius.project.AsynchronousExample2.AuctionSystem;

public class AuctionBootstrap implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// Add the memory -based AuctionSystem storage:
		AuctionSystem sys = new AuctionSystem();
		ServletContext ctx = event.getServletContext();
		ctx.setAttribute("Items", sys);
	}

}
