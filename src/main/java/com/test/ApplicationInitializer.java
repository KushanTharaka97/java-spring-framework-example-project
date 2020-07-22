package com.test;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //bootstrap dispatherservelet
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ApplicationConfig.class);
        ServletRegistration.Dynamic servletRegistration =
                servletContext.addServlet("mvc", new DispatcherServlet(context));


        //run in priority speed
        servletRegistration.setLoadOnStartup(1);

        //Mapping
        servletRegistration.addMapping("/");
    }
}
