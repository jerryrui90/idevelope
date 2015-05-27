package com.idevelope.imy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service("initializeService")
public class InitializeService implements InitializingBean
{
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    public void initialize()
    {
        
    }
    
    @Override
    public void afterPropertiesSet()
        throws Exception
    {
        logger.error("testtttttttttttttttttttttttttttttttttttttttttttttttttttttt>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}