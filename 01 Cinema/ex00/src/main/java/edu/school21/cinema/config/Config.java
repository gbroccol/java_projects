package edu.school21.cinema.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManager;

@Configuration
@ComponentScan("edu.school21.cinema")
@PropertySource("application.properties")
public class Config {

    @Value("${user.images.folder.path}")
    private String avatarsPath;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.user}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    @Value("${datasource.driver}")
    private String driver;

//    @Bean
//    public DataSource dataSource() {
//        return null;
//    }

//    @Bean
//    public EntityManager entityManager() {
//        return null;
//    }




//    public DriverManagerDataSource driverManagerDataSource() {
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//
//        driverManagerDataSource.setUrl(url);
//        driverManagerDataSource.setUsername(username);
//        driverManagerDataSource.setPassword(password);
//        driverManagerDataSource.setDriverClassName(driver);
//        return driverManagerDataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(driverManagerDataSource());
//    }




    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
}
