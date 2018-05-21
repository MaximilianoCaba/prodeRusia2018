package com.prode.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication)
            throws IOException, ServletException {
        String uriRetorno = (String) httpServletRequest.getParameter("urlRetorno");
        String urlAbsoluta = httpServletRequest.getRequestURL().toString().split(httpServletRequest.getServletPath())[0] + "/";
        if (uriRetorno == null) {
            uriRetorno = "";
        }
        httpServletResponse.sendRedirect(urlAbsoluta + uriRetorno);
    }
}
