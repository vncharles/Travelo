//package com.fit.Travelo.config;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class WebConfiguration implements WebMvcConfigurer {
//
//    @Autowired
//    private Environment env;
//    @Value("${app.security.cors.allowedMethods}")
//    private String allowedMethods;
//
//    @Value("${app.security.cors.allowedHeaders}")
//    private String allowedHeaders;
//
//    @Value("${app.security.cors.corsConfiguration}")
//    private String corsConfiguration;
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping(corsConfiguration)
//                .allowedMethods(allowedMethods)
//                .allowedHeaders(allowedHeaders);
//    }
//
//}
