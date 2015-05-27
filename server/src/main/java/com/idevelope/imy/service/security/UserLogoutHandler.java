package com.idevelope.imy.service.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class UserLogoutHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler
{
//    
//    @Autowired
//    private OperatorLogManager logManager;
//    
//    @Autowired
//    private UserManager userManager;
    
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
        throws IOException, ServletException
    {
//        User user = (User)authentication.getPrincipal();
//        
//        try
//        {
//            if (null != user)
//            {
//                String userName = user.getUsername();
//                com.shunshiwei.babycloud.domain.user.User dbUser = userManager.findUnique("accountNo", userName);
//                Long schoolId = 0l;
//                if (null == schoolId)
//                {
//                    schoolId = dbUser.getSchool().getSchoolid();
//                }
//                logManager.recordLog(dbUser.getAlias(), schoolId, "×¢Ïú");
//            }
//        }
//        catch (Exception e)
//        {
//            
//        }
        super.onLogoutSuccess(request, response, authentication);
    }
}
