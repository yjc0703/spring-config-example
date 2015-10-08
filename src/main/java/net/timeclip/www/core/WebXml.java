package net.timeclip.www.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebXml implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        
        AnnotationConfigWebApplicationContext rootConfig = 
                new AnnotationConfigWebApplicationContext();
        rootConfig.register(RootConfig.class);
        
        servletContext.addListener(new ContextLoaderListener(rootConfig));
        
        AnnotationConfigWebApplicationContext servletConfig 
            = new AnnotationConfigWebApplicationContext();
        servletConfig.register(ServletConfig.class);
        
        Dynamic dispatcher = servletContext.addServlet("appServlet", new DispatcherServlet(servletConfig));
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);
    }
    
}
