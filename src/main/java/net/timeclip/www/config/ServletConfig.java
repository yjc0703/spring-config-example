package net.timeclip.www.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "net.timeclip.www")
public class ServletConfig extends WebMvcConfigurerAdapter {
    
    private static final Logger log = LoggerFactory.getLogger(ServletConfig.class);
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resource/**").addResourceLocations("/resource/");
    }
    
    @Bean
    public ViewResolver internalResourceViewResolver() {
        
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        
        log.debug("viewResolver init!!!!");
        
        return resolver;
    }
    
    @Bean
    MappingJackson2HttpMessageConverter converter() {
        
        MappingJackson2HttpMessageConverter converter
            = new MappingJackson2HttpMessageConverter(new ObjectMapper());
        
        return converter;
    }
    
}
