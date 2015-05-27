package com.idevelope.imy.service.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.switchuser.SwitchUserFilter;

public class SwitchUserProcessor extends SwitchUserFilter
{
    @Override
    protected Authentication attemptSwitchUser(HttpServletRequest request) throws AuthenticationException {
        return super.attemptSwitchUser(request);
    }

    @Override
    protected Authentication attemptExitUser(HttpServletRequest request) throws AuthenticationCredentialsNotFoundException {
        return super.attemptExitUser(request);
    }
}
