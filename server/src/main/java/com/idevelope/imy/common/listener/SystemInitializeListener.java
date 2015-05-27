package com.idevelope.imy.common.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.idevelope.imy.service.InitializeService;

public class SystemInitializeListener extends ContextLoaderListener
{
    private static Logger LOGGER = LoggerFactory.getLogger(SystemInitializeListener.class);
    
    private static ServletContext servletContext;
    
    private static ApplicationContext applicationContext;
    
    public static ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }
    
    public static ServletContext getServletContext()
    {
        return servletContext;
    }
    
    public void contextInitialized(ServletContextEvent event)
    {
        LOGGER.debug("initializing context...");

        ServletContext servletContext = event.getServletContext();
        String value = servletContext.getInitParameter("contextConfigLocation");
        super.contextInitialized(event);

        ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        JdbcTemplate initializeService = (JdbcTemplate)context.getBean("jdbcTemplate");
//        initializeService.initialize();
    }
    
    public static void setupContext(ServletContext context)
    {
        servletContext = context;
        applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
    }
}