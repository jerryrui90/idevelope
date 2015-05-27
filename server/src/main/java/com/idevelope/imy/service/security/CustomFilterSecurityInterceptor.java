package com.idevelope.imy.service.security;

import java.io.IOException;

import javax.servlet.*;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class CustomFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter
{
    private FilterInvocationSecurityMetadataSource securityMetadataSource;
    
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
        throws IOException, ServletException
    {
        FilterInvocation fi = new FilterInvocation(arg0, arg1, arg2);
        invoke(fi);
    }
    
    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource()
    {
        return this.securityMetadataSource;
    }
    
    // �Զ���ķ���
    public void invoke(FilterInvocation fi)
        throws IOException, ServletException
    {
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try
        {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        }
        finally
        {
            super.afterInvocation(token, null);
        }
    }
    
    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource()
    {
        return securityMetadataSource;
    }
    
    public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource)
    {
        this.securityMetadataSource = securityMetadataSource;
    }
    
    @Override
    public Class<?> getSecureObjectClass()
    {
        return FilterInvocation.class;
    }
    
    public void destroy()
    {
        
    }
    
    public void init(FilterConfig arg0)
        throws ServletException
    {
        
    }
}
