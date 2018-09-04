package com.qoobico.testserver;

import com.qoobico.testserver.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {

    private final  static  String DISPATCHER = "dispatcher";
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(WebConfig.class);
        servletContext.addListener(new ContextLoaderListener(applicationContext));


        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER, new DispatcherServlet(applicationContext));

        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
