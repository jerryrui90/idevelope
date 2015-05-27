package com.idevelope.imy.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * Created by dk on 2015/5/20.
 */
@Service
public class ProductManager implements InitializingBean
{
    private Logger LOGGER = LoggerFactory.getLogger(ProductManager.class);
    
    @Override
    public void afterPropertiesSet()
        throws Exception
    {
        LOGGER.debug("teset>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
