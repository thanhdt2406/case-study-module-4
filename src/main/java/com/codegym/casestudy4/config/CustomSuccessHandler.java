package com.codegym.casestudy4.config;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.service.appuser.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private IAppUserService appUserService;

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication);
        if(response.isCommitted()){
            return;
        }
        redirectStrategy.sendRedirect(request,response,targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication){
        String url;
        AppUser currentUser = appUserService.getUserLogin();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();
        for(GrantedAuthority authority:authorities){
            roles.add(authority.getAuthority());
        }
        if (currentUser.isStatus()){
            if(isAdmin(roles)){
                url="/admins";
            } else if(isUser(roles)){
                url="/customer";
            } else if(isShop(roles)){
                url="/shops";
            } else {
                url = "/deny";
            }
        }else {
            url = "/banned";
        }

        return url;
    }

    private boolean isUser(List<String> roles){
        return roles.contains("ROLE_USER");
    }

    private boolean isAdmin(List<String> roles){
        return roles.contains("ROLE_ADMIN");
    }

    private boolean isShop(List<String> roles){
        return roles.contains("ROLE_SHOP");
    }

    @Override
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
}
