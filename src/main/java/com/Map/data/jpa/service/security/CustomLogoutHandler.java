package com.Map.data.jpa.service.security;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by easyw on 25-Mar-18.
 */
public class CustomLogoutHandler implements LogoutHandler {
    private UserCache userCache;

    public void logout(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) {
        HttpSession session = request.getSession(false);
        if(request.isRequestedSessionIdValid() && session != null)
        {
            session.invalidate();
        }
    }

    @Required
    public void setUserCache(final UserCache userCache) {
        this.userCache = userCache;
    }
}
