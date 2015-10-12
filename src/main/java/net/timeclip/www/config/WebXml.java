package net.timeclip.www.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebXml implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        
        // root-context
        AnnotationConfigWebApplicationContext rootConfig = 
                new AnnotationConfigWebApplicationContext();
        rootConfig.register(RootConfig.class);
        
        servletContext.addListener(new ContextLoaderListener(rootConfig));
        
        // servlet-context
        AnnotationConfigWebApplicationContext servletConfig 
            = new AnnotationConfigWebApplicationContext();
        servletConfig.register(ServletConfig.class);
        
        // dispatcher servlet
        ServletRegistration.Dynamic dispatcher 
            = servletContext.addServlet("appServlet", new DispatcherServlet(servletConfig));
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);
        
        // encoding filter
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        
        FilterRegistration.Dynamic characterEncoding 
            = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
        characterEncoding.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        
    }
    
}
