package net.timeclip.www.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "net.timeclip.www", excludeFilters = @Filter(classes = Configuration.class))
public class RootConfig {
    
    private final static Logger log = LoggerFactory.getLogger(RootConfig.class);
    
    @Bean
    public InitializingBean init() {
        return new InitializingBean() {
            
            @Override
            public void afterPropertiesSet() throws Exception {
                log.debug("init!!!!");
            }
        };
    }
}
