package com.prode.config;


import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorComponentConfig implements EmbeddedServletContainerCustomizer {
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403"));
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
        container.addErrorPages(new ErrorPage(Exception.class, "/error"));
    }
}
