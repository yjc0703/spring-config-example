package net.timeclip.www.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebXml implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        
        XmlWebApplicationContext rootConfig = new XmlWebApplicationContext();
        rootConfig.setConfigLocation("/WEB-INF/spring/root-context.xml");
        
        servletContext.addListener(new ContextLoaderListener(rootConfig));
        
        XmlWebApplicationContext servletConfig = new XmlWebApplicationContext();
        servletConfig.setConfigLocation("/WEB-INF/spring/appServlet/servlet-context.xml");
        
        Dynamic dispatcher = servletContext.addServlet("appServlet", new DispatcherServlet(servletConfig));
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);
        
    }
    
}
