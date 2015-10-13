package net.timeclip.www.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.h2.Driver;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.zaxxer.hikari.HikariDataSource;

import net.timeclip.www.common.annotation.Mapper;

@Configuration
@MapperScan(annotationClass = Mapper.class, basePackages = "net.timeclip.www")
@EnableTransactionManagement
public class MybatisConfig implements TransactionManagementConfigurer {

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName(Driver.class.getName());
        ds.setJdbcUrl("jdbc:h2:mem:test");
        ds.setUsername("sa");
        ds.setPassword("");
        
        DatabasePopulatorUtils.execute(new ResourceDatabasePopulator(
                new ClassPathResource("__scheme.sql")), ds);

        return ds;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml"));
        bean.setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis.xml"));
        
        return bean.getObject();
    }
    
    @Bean
    public SqlSession sqlSession(SqlSessionFactory sqlSessionFactory) throws Exception {
        // warn error 제거용
        return new SqlSessionTemplate(sqlSessionFactory) {
            @Override public void close() {}
        };
    }
}
