package com.idevelope.imy.service.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

@Service(value = "customSecurityMetadataSource")
public class InvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean,
    RowMapper<ResourceDetail>
{
    String sql =
        "select m.res_url,r.name from maintain_role r, maintain_role_auth ra, maintain_auth m where r.id = ra.role_id and ra.auth_id = m.auth_id order by ra.auth_id";
    
    @Autowired
    JdbcTemplate jdbc;
    
    private PathMatcher urlMatcher = new AntPathMatcher();
    
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
    
    public Collection<ConfigAttribute> getAttributes(Object object)
        throws IllegalArgumentException
    {
        Collection<ConfigAttribute> collection = null;
        
        String url = ((FilterInvocation)object).getRequestUrl();
        // resourceMap������loadResourceDefine�������ؽ���������
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext())
        {
            // ȡ��resourceMap�ж�ȡ���ݿ��url��ַ
            String resURL = ite.next();
            // ������� url��ַ��ͬ����ô������resourceMap�ж�Ӧ��Ȩ�޼��ϣ�Ȼ����ת��MyAccessDecisionManager�����decide���������ж�Ȩ��
            if (urlMatcher.match(resURL, url))
            {
                // ���ض�Ӧ��url��ַ��Ȩ�� ��resourceMap��һ������Ϊ��ַ��ֵΪȨ�޵ļ��϶���
                collection = resourceMap.get(resURL);
                break;// ���ض�Ӧ��url��ַ��Ȩ�� ��resourceMap��һ������Ϊ��ַ��ֵΪȨ�޵ļ��϶���
            }
        }
        // ������������url��ַû��ƥ�䣬����return null�����ٵ���MyAccessDecisionManager�����decide��������Ȩ����֤�������������ҳ��
        if (null == collection)
        {
            collection = new ArrayList<ConfigAttribute>();
            collection.add(new SecurityConfig("ROLE_NO_USER"));
        }
        return collection;
    }
    
    public Collection<ConfigAttribute> getAllConfigAttributes()
    {
        return null;
    }
    
    public boolean supports(Class<?> clazz)
    {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
    
    private Map<String, Collection<ConfigAttribute>> loadResourceMatchAuthority()
    {
        Map<String, Collection<ConfigAttribute>> map = new HashMap<String, Collection<ConfigAttribute>>();
        List<ResourceDetail> resources = jdbc.query(sql, this);
        // resUrl, roleName
        for (ResourceDetail right : resources)
        {
            String resUrl = right.getName();
            String roleName = right.getRole();
            if (StringUtils.isEmpty(roleName))
            {
                roleName = "ROLE_ANONYMOUS";
            }
            
            Collection<ConfigAttribute> configList = map.get(resUrl);
            if (configList == null)
            {
                configList = new ArrayList<ConfigAttribute>();
                
            }
            ConfigAttribute config = new SecurityConfig(roleName);
            configList.add(config);
            map.put(resUrl, configList);
        }
        return map;
    }
    
    public void flushRight()
    {
        resourceMap = loadResourceMatchAuthority();
    }
    
    public void afterPropertiesSet()
        throws Exception
    {
        resourceMap = loadResourceMatchAuthority();
    }
    
    public ResourceDetail mapRow(ResultSet rs, int arg1)
        throws SQLException
    {
        String url = rs.getString(1);
        String role = rs.getString(2);
        ResourceDetail resource = new ResourceDetail(url, role);
        return resource;
    }
}
