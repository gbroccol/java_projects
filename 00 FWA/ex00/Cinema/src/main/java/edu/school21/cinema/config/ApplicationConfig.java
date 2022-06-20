package edu.school21.cinema.config;

import edu.school21.cinema.repositories.UserAuthenticationRepository;
import edu.school21.cinema.repositories.UserRepository;
//import edu.school21.cinema.services.AvatarService;
import edu.school21.cinema.services.AvatarService;
import edu.school21.cinema.services.UserAuthenticationService;
import edu.school21.cinema.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("edu.school21.cinema")
@PropertySource("application.properties")
@RequiredArgsConstructor
public class ApplicationConfig {

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

    public DriverManagerDataSource driverManagerDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);
        driverManagerDataSource.setDriverClassName(driver);
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(driverManagerDataSource());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository(jdbcTemplate());
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository());
    }

    @Bean
    public UserAuthenticationRepository userAuthenticationRepository() {
        return new UserAuthenticationRepository(jdbcTemplate());
    }

    @Bean
    public UserAuthenticationService userAuthenticationService() {
        return new UserAuthenticationService(userAuthenticationRepository());
    }

    @Bean
    public AppConf appConf() {
        return new AppConf(avatarsPath);
    }

    @Bean
    public AvatarService avatarService() { return new AvatarService(avatarsPath); }
}