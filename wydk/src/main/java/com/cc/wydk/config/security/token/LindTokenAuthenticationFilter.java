package com.cc.wydk.config.security.token;

import com.cc.wydk.entity.AdminUser;
import com.cc.wydk.enumDate.ExceptionEnum;
import com.cc.wydk.exception.BusinessInterfaceException;
import com.cc.wydk.service.AdminUserService;
import com.cc.wydk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LindTokenAuthenticationFilter extends OncePerRequestFilter {

    String tokenHeader = "x_token";
    String username = "username";

    @Autowired
    public UserService userService;

    @Autowired
    public AdminUserService adminUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.tokenHeader);
        String username = request.getHeader(this.username);
        if (!StringUtils.isEmpty(authHeader) && !StringUtils.isEmpty(username)) {
            if (com.alibaba.druid.util.StringUtils.isNumber(username) && username.length() == 11) {
                UserDetails userDetails = this.userService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                        request));
                logger.info("authenticated user " + username + ", setting security context");
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                AdminUser byUserName = adminUserService.getByUserName(username);
                if (null == byUserName) {
                    throw new BusinessInterfaceException(ExceptionEnum.FAILURELOGIN.getCode(), ExceptionEnum.FAILURELOGIN.getMsg());
                }
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(byUserName, null, null);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                logger.info("authenticated user " + username + ", setting security context");
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        } else {
            if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
                throw new ServletException("OncePerRequestFilter just supports HTTP requests");
            }
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;

            String alreadyFilteredAttributeName = getAlreadyFilteredAttributeName();
            boolean hasAlreadyFilteredAttribute = request.getAttribute(alreadyFilteredAttributeName) != null;

            if (skipDispatch(httpRequest) || shouldNotFilter(httpRequest)) {

                // Proceed without invoking this filter...
                filterChain.doFilter(request, response);
            } else if (hasAlreadyFilteredAttribute) {

                if (DispatcherType.ERROR.equals(request.getDispatcherType())) {
                    doFilterNestedErrorDispatch(httpRequest, httpResponse, filterChain);
                    return;
                }

                // Proceed without invoking this filter...
                filterChain.doFilter(request, response);
            } else {
                // Do invoke this filter...
                request.setAttribute(alreadyFilteredAttributeName, Boolean.TRUE);
                try {
                    doFilterInternal(httpRequest, httpResponse, filterChain);
                } finally {
                    // Remove the "already filtered" request attribute for this request.
                    request.removeAttribute(alreadyFilteredAttributeName);
                }
            }
        }
    }

    private boolean skipDispatch(HttpServletRequest request) {
        if (isAsyncDispatch(request) && shouldNotFilterAsyncDispatch()) {
            return true;
        }
        if (request.getAttribute(WebUtils.ERROR_REQUEST_URI_ATTRIBUTE) != null && shouldNotFilterErrorDispatch()) {
            return true;
        }
        return false;
    }
}
